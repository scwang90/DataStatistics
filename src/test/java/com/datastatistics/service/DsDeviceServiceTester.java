package com.datastatistics.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datastatistics.model.DsDevice;
import com.datastatistics.util.JacksonUtil;

/**
 * 数据库表ds_device的Service层测试类
 * @author 树朾
 * @date 2015-07-28 23:44:11 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class DsDeviceServiceTester {

	@Autowired
	DsDeviceService service;
	
	@Test
	public void insert() throws Exception{
		DsDevice model = new DsDevice();
		Object result = service.insert(model);
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void update() throws Exception {
		DsDevice model = new DsDevice();
		Object result = service.update(model);
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void delete() throws Exception {
		Object result = service.delete("1");
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void countAll() throws Exception {
		Object result = service.countAll();
		System.out.println(JacksonUtil.toJson(result));
	}
	
	
}
