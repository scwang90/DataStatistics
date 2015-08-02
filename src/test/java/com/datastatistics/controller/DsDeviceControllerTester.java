package com.datastatistics.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.datastatistics.controller.util.AfDateGuid;
import com.datastatistics.model.DsDevice;
import com.datastatistics.util.AfDesHelper;
import com.datastatistics.util.AfMD5;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler.HttpMethod;
import com.simple.toadiot.rtinfosdk.http.DefaultResponseHandler;
import com.simple.toadiot.rtinfosdk.http.Response;

/**
 * 数据库表ds_device 的Controller层测试类
 * @author 树朾
 * @date 2015-07-28 23:44:11 中国标准时间
 */
public class DsDeviceControllerTester{

	DefaultRequestHandler handler = DefaultRequestHandler.getInstance();
	
	@Before
	public void before(){
		DefaultRequestHandler.DEBUG = true;
		DefaultResponseHandler.JSONFRAMEWORK = false;
	}
	
	
	@Test
	public void initDevice() throws Exception{
		Map<String, String> header = buildToken();
		DsDevice model = new DsDevice();
		model.setAppId("1");
		model.setUniqueId(AfDateGuid.NewID());
		String path = "/DsDevice/InitDevice/waps";
		Response response = handler.doRequest(HttpMethod.POST, path,header,model);
		System.out.println(response.getBody());
	}

	@Test
	public void uninstall() throws Exception{
		Map<String, String> header = buildToken();
		DsDevice model = new DsDevice();
		model.setAppId("1");
		model.setUniqueId("20150801192409106409");
		String path = "/DsDevice/Uninstall/waps";
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
