package com.datastatistics.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.datastatistics.controller.util.AfDateGuid;
import com.datastatistics.model.DsExceptional;
import com.datastatistics.util.AfDesHelper;
import com.datastatistics.util.AfMD5;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler.HttpMethod;
import com.simple.toadiot.rtinfosdk.http.DefaultResponseHandler;
import com.simple.toadiot.rtinfosdk.http.Response;

/**
 * 数据库表ds_exceptional 的Controller层测试类
 * @author 树朾
 * @date 2015-07-28 23:44:11 中国标准时间
 */
public class DsExceptionalControllerTester {

	DefaultRequestHandler handler = DefaultRequestHandler.getInstance();
	
	@Before
	public void before(){
		DefaultRequestHandler.DEBUG = true;
		DefaultResponseHandler.JSONFRAMEWORK = false;
	}
	
	@Test
	public void exceptional() throws Exception{
		Map<String, String> header = buildToken();
		DsExceptional model = new DsExceptional();
		model.setAppId("1");
		model.setName("NullPointerException");
		model.setVersion("1.3.2.0");
		model.setStatus(0);
//		model.setUniqueId("20150731003927874800");
		model.setChannel("wpas");
//		model.setExceptionalId("adclick");
		String path = "/DsExceptional/Exceptional";
		Response response = handler.doRequest(HttpMethod.POST, path,header,model);
		System.out.println(response.getBody());
	}
	
	private Map<String, String> buildToken() throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> header = new HashMap<String, String>();
		String strkey = AfMD5.getMD5("");
		AfDesHelper helper = new AfDesHelper(strkey);
		String token = AfDateGuid.NewID();
		token = token + new StringBuffer(token).reverse();
		header.put("token", helper.encrypt(token));
		return header;
	}

}
