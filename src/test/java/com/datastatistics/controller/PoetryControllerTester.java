package com.datastatistics.controller;

import com.datastatistics.model.SnSameNameError;
import com.datastatistics.util.AfDesHelper;
import com.datastatistics.util.AfMD5;
import com.datastatistics.util.JacksonUtil;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler;
import com.simple.toadiot.rtinfosdk.http.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库表sn_same_name_error 的Controller层测试类
 * @author 树朾
 * @date 2015-07-28 23:44:11 中国标准时间
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring-*.xml")
public class PoetryControllerTester {

	@Autowired
	PoetryController controller;

	@Test
	public void token() throws Exception{
		System.out.println(new AfDesHelper(AfMD5.getMD5("")).encrypt("1221"));
	}

	@Test
	public void kernel() throws Exception{
		SnSameNameError model = new SnSameNameError();
		Object result = controller.kernel(new AfDesHelper(AfMD5.getMD5("")).encrypt("1221"),"唯爱紫夕",5,1,1);
		System.out.println(JacksonUtil.toJson(result));
	}

	@Test
	public void client() throws Exception{
		DefaultRequestHandler requestHandler = DefaultRequestHandler.getInstance();
		DefaultRequestHandler.HttpMethod method;
		method = DefaultRequestHandler.HttpMethod.GET;
//		String path = "/poetry/kernel/为爱紫夕/5/1/1";
		String path = "/poetry/kernel/5/1/1";
		Map<String, String> header = new HashMap<>();
		header.put("token","382a39944fc206f8");
		Map<String, Object> param = new HashMap<>();
		param.put("key","为爱紫夕");
		Response response = requestHandler.doRequest(method, path, header, null, param);
		System.out.println(response.getBody());
	}

}
