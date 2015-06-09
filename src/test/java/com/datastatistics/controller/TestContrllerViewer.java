package com.datastatistics.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpException;
import org.junit.Before;
import org.junit.Test;

import com.datastatistics.model.SnSameName;
import com.simple.toadiot.rtinfosdk.AppConfig;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler.HttpMethod;
import com.simple.toadiot.rtinfosdk.http.DefaultResponseHandler;
import com.simple.toadiot.rtinfosdk.http.Response;

public class TestContrllerViewer {
	
	DefaultRequestHandler request = DefaultRequestHandler.getInstance();

	@Before
	public void init() {
		DefaultRequestHandler.DEBUG = true;
		DefaultResponseHandler.DEBUG = true;
		DefaultResponseHandler.JSONFRAMEWORK = false;
		AppConfig.setCharset("UTF-8");
	}

	@Test
	public void RequestBody() throws HttpException {
		try {
			String path = "/RequestBody/submit";
			HttpMethod method = HttpMethod.POST;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> header = new HashMap<String, String>();
			SnSameName body = new SnSameName();
			body.setSameName("234");
			body.setKeyId("3333");
			Response response = request.doRequest(method,path,header,body ,param);
			for (Entry<String, String> entry : response.getHeaders().entrySet()) {
				System.out.println("p-"+entry.getKey()+"="+entry.getValue());
			}
			System.out.println(response.getBody());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println();
	}

	@Test
	public void ResponseBody() throws HttpException {
		try {
			String path = "/ResponseBody/submit";
			HttpMethod method = HttpMethod.POST;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> header = new HashMap<String, String>();
			header.put("Accept-Encoding", "scwang");
			Response response = request.doRequest(method,path,header,null,param);
			for (Entry<String, String> entry : response.getHeaders().entrySet()) {
				System.out.println("p-"+entry.getKey()+"="+entry.getValue());
			}
			System.out.println(response.getBody());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println();
	}

	@Test
	public void ResponseBodyProduces() throws HttpException {
		try {
			String path = "/ResponseBodyProduces/submit";
			HttpMethod method = HttpMethod.POST;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> header = new HashMap<String, String>();
			header.put("Accept-Encoding", "scwang");
			Response response = request.doRequest(method,path,header,null,param);
			for (Entry<String, String> entry : response.getHeaders().entrySet()) {
				System.out.println("p-"+entry.getKey()+"="+entry.getValue());
			}
			System.out.println(response.getBody());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println();
	}

	@Test
	public void RestfulEntity() throws HttpException {
		try {
			String path = "/RestfulEntity/submit";
			HttpMethod method = HttpMethod.POST;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> header = new HashMap<String, String>();
			header.put("Accept-Encoding", "scwang");
			Response response = request.doRequest(method,path,header,null,param);
			for (Entry<String, String> entry : response.getHeaders().entrySet()) {
				System.out.println("p-"+entry.getKey()+"="+entry.getValue());
			}
			System.out.println(response.getBody());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println();
	}
	

}
