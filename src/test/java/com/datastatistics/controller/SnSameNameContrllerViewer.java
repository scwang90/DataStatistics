package com.datastatistics.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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

public class SnSameNameContrllerViewer {

	public static String URL = "http://zhaoren.idtag.cn/samename/searchName!getProvinces.htm?name=";
	
	DefaultRequestHandler request = DefaultRequestHandler.getInstance();

	@Before
	public void init() {
		DefaultRequestHandler.DEBUG = true;
		DefaultResponseHandler.DEBUG = true;
		DefaultResponseHandler.JSONFRAMEWORK = false;
		AppConfig.setCharset("UTF-16");
	}
	

	@Test
	public void Jsoup() throws HttpException {
		
	}
	
	@Test
	public void submit() throws HttpException {
		try {
			HttpMethod method = HttpMethod.POST;
			SnSameName name = new SnSameName();
			name.setSameName("树朾-Viewer-"+new Date().getTime());
			name.setCountProvince("[{e:[22,33]},{e:[22,33]}]");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sameName", "树朾");
			map.put("countProvince", "[{e:[22,33]},{e:[22,33]}]");
			Response response = request.doRequest(method , "/SnSameName/add",null,name,null);
			for (Entry<String, String> entry : response.getHeaders().entrySet()) {
				System.out.println("p-"+entry.getKey()+"="+entry.getValue());
			}
			System.out.println(response.getBody());
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
