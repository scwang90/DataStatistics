// Copyright (c) 2003-2013, LogMeIn, Inc. All rights reserved.
// This is part of Xively4J library, it is under the BSD 3-Clause license.
package com.simple.toadiot.rtinfosdk.http;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.simple.toadiot.rtinfosdk.util.ParserUtil;
import com.simple.toadiot.rtinfosdk.util.exception.ParseToObjectException;

/**
 * Wrapper to decouple response implementation from the rest of the library
 * 
 * @author s0pau
 * 
 */
public class Response {
	
	public static final String HEADER_NEW_OBJ_URI = "Location";

	private int statusCode;
	private Map<String, String> headers;
	private String body;

	public Response() {
		// TODO Auto-generated constructor stub
	}
	
	public Response(int statusCode) {
		// TODO Auto-generated constructor stub
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public String getHeaders(String key) {
		return headers.get(key);
	}

	/**
	 * Shallow cope the collection of headers
	 * 
	 * @param headers
	 */
	public void setHeaders(Map<String, String> headers) {
		this.headers = new HashMap<String, String>();
		this.headers.putAll(headers);
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public <T> T getBodyAsObject(Class<T> returnType)
			throws ParseToObjectException {
		return ParserUtil.toConnectedObject(body, returnType);
	}

	public <T> List<T> getBodyAsObjects(Class<T> returnType)
			throws ParseToObjectException, JsonParseException,
			JsonMappingException, IOException {
		return ParserUtil.toConnectedObjects(body, returnType);
	}

	/**
	 * @return the id of object as indicated in the headers, e.g. for Feed and
	 *         Trigger; null if no such header is found.
	 */
	public String getIdFromResponse() {
		String feedUrlStr = getHeaders(HEADER_NEW_OBJ_URI);
		String[] tokens = feedUrlStr.split("/");
		return tokens[tokens.length - 1];
	}

	public JSONObject getJSONObject() throws Exception {
		// TODO Auto-generated method stub
		try {
			return new JSONObject(body);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServerException("服务器返回格式异常："+body,e);
		}
	}
}
