// Copyright (c) 2003-2013, LogMeIn, Inc. All rights reserved.
// This is part of Xively4J library, it is under the BSD 3-Clause license.
package com.simple.toadiot.rtinfosdk.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.simple.toadiot.rtinfosdk.AppConfig;
import com.simple.toadiot.rtinfosdk.AppConfig.AcceptedMediaType;
import com.simple.toadiot.rtinfosdk.util.ParserUtil;
import com.simple.toadiot.rtinfosdk.util.StringUtil;

/**
 * Handler for building and making requests, uses {@link DefaultResponseHandler}
 * to process the response
 * 
 * @author s0pau
 */
public class DefaultRequestHandler {
	
	public static boolean DEBUG = false;

//	private static final String HEADER_KEY_API = "X-ApiKey";
//	private static final String HEADER_USER_AGENT = "User Agent";
//	private static final String XIVELY_USER_AGENT = "Xively-Java-Lib/0.1.0-SNAPSHOT";

	private DefaultHttpClient httpClient;

	private static DefaultRequestHandler instance;

	public enum HttpMethod {
		DELETE, GET, POST, PUT;
	}

	private DefaultRequestHandler() {
		// singleton
	}

	public static DefaultRequestHandler getInstance() {
		if (instance == null) {
			instance = new DefaultRequestHandler();
		}
		return instance;
	}

	public Response doRequest(HttpMethod method, String path) throws HttpException {
		return doRequest(method, path, null,null,null);
	}

	public Response doRequest(HttpMethod method, String path, Object body) throws HttpException {
		return doRequest(method, path, null, body,null);
	}

	public  Response doRequest(HttpMethod method, String path, Map<String, String> headers) throws HttpException {
		return doRequest(method, path, headers, null,null);
	}

	public  Response doRequest(HttpMethod method, String path, Map<String, String> headers, Object body) throws HttpException {
		return doRequest(method, path, headers, body,null);
	}

	public Response doRequest(HttpMethod method, String path, Map<String, String> headers, Map<String, Object> params) throws HttpException {
		return doRequest(method, path,headers,null, params);
	}

	/**
	 * * Make the request to Xively API and return the response string
	 * 
	 * @param <T extends ConnectedObject>
	 * 
	 * @param method
	 *            http request methods
	 * @param path
	 *            restful app path
	 * @param body
	 *            objects to be parsed as body for api call
	 * @param params
	 *            key-value of params for api call
	 * @param headers 
	 * 
	 * @return response string
	 * @throws HttpException 
	 */

	public Response doRequest(HttpMethod method, String path, Map<String, String> headers,
			Object body,Map<String, Object> params) throws HttpException {
		Response response = null;
		HttpRequestBase request = buildRequest(method, path,headers,body, params);

		try {
			if (DEBUG) {
				System.out.println(request);
				for (Header header : request.getAllHeaders()) {
					System.out.println(header);
				}
				if (body != null) {
					System.out.println(EntityUtils.toString(getEntity(body),AppConfig.getCharset()));
				}
				//System.out.println(request.getParams());
			}
			DefaultResponseHandler responseHandler = new DefaultResponseHandler();
			response = getClient().execute(request, responseHandler);
		} catch (IOException e) {
			throw new HttpException(
					"Http request did not return successfully.", e);
//		} catch (RuntimeException e) {
//			// release resources manually on unexpected exceptions
//			request.abort();
//			throw new HttpException(
//					"Http request did not return successfully.", e);
		}

		return response;
	}

	private DefaultHttpClient getClient() {
		if (httpClient == null) {
			httpClient = HttpClientBuilder.getInstance().getHttpClient();
		}
		return httpClient;
	}

	private HttpRequestBase buildRequest(HttpMethod method, String path,Map<String, String> headers,
			Object body,Map<String, Object> params) {
		AcceptedMediaType mediaType = AppConfig.getResponseMediaType();

		HttpRequestBase request = null;
		StringEntity entity = getEntity(body);
		switch (method) {
		case DELETE:
			request = new HttpDelete();
			break;
		case GET:
			request = new HttpGet();
			break;
		case POST:
			request = new HttpPost();
			if (entity != null) {
				((HttpPost) request).setEntity(entity);
			}
			break;
		case PUT:
			request = new HttpPut();
			if (entity != null) {
				((HttpPut) request).setEntity(entity);
			}
			break;
		default:
			return null;
		}

		try {
			if (!path.toLowerCase(Locale.ENGLISH).startsWith("http")) {
				URIBuilder uriBuilder = buildUri(method, path, params,mediaType);
					request.setURI(uriBuilder.build());
			}else {
				request.setURI(new URI(path));
			}
		} catch (URISyntaxException e) {
			throw new RequestInvalidException("Invalid URI requested.", e);
		}
//		request.addHeader("accept", mediaType.getMediaType());
//		request.addHeader(HEADER_KEY_API, AppConfig.getInstance().getApiKey());
//		request.addHeader(HEADER_USER_AGENT, XIVELY_USER_AGENT);
		/**
		 * 设置 Header
		 */
		request.addHeader("Content-Type", mediaType.getMediaType()+";charset="+AppConfig.getCharset());
		if (headers != null && !headers.isEmpty()) {
			int index = 0;
			Header[] header = new Header[headers.size()];
			for (Entry<String, String> element : headers.entrySet()) {
				header[index++] = new BasicHeader(element.getKey(),
						element.getValue());
			}
			request.setHeaders(header);
		}
//		if (params != null && !params.isEmpty()) {
//			HttpParams hparams = new SyncBasicHttpParams();
//			for (Entry<String, Object> param : params.entrySet()) {
//				hparams.setParameter(param.getKey(), param.getValue());
//			}
//			request.setParams(hparams);
//		}
		return request;
	}

	private URIBuilder buildUri(HttpMethod method, String path,
			Map<String, Object> params, AcceptedMediaType mediaType) {
		URIBuilder uriBuilder = new URIBuilder();
//		if (HttpMethod.GET == method) {
//			path = path.concat(".").concat(mediaType.name());
//		}
		uriBuilder.setScheme("http").setHost(AppConfig.getBaseURI()).setPath("/"+AppConfig.getVersion()+path);
		if (params != null && !params.isEmpty()) {
			for (Entry<String, Object> param : params.entrySet()) {
				uriBuilder.addParameter(param.getKey(),
						StringUtil.toString(param.getValue()));
			}
		}
		return uriBuilder;
	}

	private StringEntity getEntity(Object body) {
		
		AcceptedMediaType mediaType = AppConfig.getResponseMediaType();
		
		String json = null;//ParserUtil.toJson(body);

		if (body instanceof JSONObject || body instanceof String) {
			// 封装一个 JSON 对象
			json = body.toString();
		} else if (body != null) {
			json = ParserUtil.toJson(body);
		}else {
			return null;
		}

		StringEntity entity = null;
		try {
			entity = new StringEntity(json,AppConfig.getCharset());
			entity.setContentType(mediaType.getMediaType());
		} catch (UnsupportedEncodingException e) {
			throw new RequestInvalidException(
					"Unable to encode json string for making request.", e);
		}

		return entity;
	}
}
