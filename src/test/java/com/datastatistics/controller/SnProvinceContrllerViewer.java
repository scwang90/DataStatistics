package com.datastatistics.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;
import org.junit.Before;
import org.junit.Test;

import com.datastatistics.model.SnSameName;
import com.datastatistics.util.JacksonUtil;
import com.simple.toadiot.rtinfosdk.AppConfig;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler.HttpMethod;
import com.simple.toadiot.rtinfosdk.http.DefaultResponseHandler;
import com.simple.toadiot.rtinfosdk.http.Response;

public class SnProvinceContrllerViewer {
	
	DefaultRequestHandler request = DefaultRequestHandler.getInstance();

	@Before
	public void init() {
		DefaultRequestHandler.DEBUG = true;
		DefaultResponseHandler.DEBUG = true;
		DefaultResponseHandler.JSONFRAMEWORK = false;
		AppConfig.setCharset("UTF-16");
	}
	

	@Test
	public void getALl() throws HttpException {
		try {
			HttpMethod method = HttpMethod.POST;
			SnSameName name = new SnSameName();
			name.setSameName("树朾");
			name.setCountProvince("[{e:[22,33]},{e:[22,33]}]");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sameName", JacksonUtil.toJson(name));
			Response doRequest = request.doRequest(method , "/SnProvince/getAll",null,null,map);
			System.out.println("Headers"+JacksonUtil.toJson(doRequest.getHeaders()));
			System.out.println(doRequest.getBody());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJson() {
		System.out.println(JacksonUtil.toJson(null));
		System.out.println(JacksonUtil.toObject("null", SnSameName.class));
	}

}
