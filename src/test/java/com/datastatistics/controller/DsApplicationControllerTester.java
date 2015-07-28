package com.datastatistics.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datastatistics.model.DsApplication;
import com.datastatistics.util.JacksonUtil;

/**
 * 数据库表ds_application 的Controller层测试类
 * @author 树朾
 * @date 2015-07-28 23:44:11 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class DsApplicationControllerTester {

	@Autowired
	DsApplicationController controller;
	
	@Test
	public void add() throws Exception{
		DsApplication model = new DsApplication();
		Object result = controller.add(model);
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void update() throws Exception {
		DsApplication model = new DsApplication();
		Object result = controller.update(model);
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void delete() throws Exception {
		Object result = controller.delete("1");
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void countAll() throws Exception {
		Object result = controller.countAll();
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void getByID() throws Exception {
		Object result = controller.getByID("1");
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void getListByPage() throws Exception {
		Object result = controller.getListByPage(6, 0);
		System.out.println(JacksonUtil.toJson(result));
	}

}
