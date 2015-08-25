package com.datastatistics.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datastatistics.model.DsDeploy;
import com.datastatistics.util.JacksonUtil;

/**
 * 数据库表ds_deploy 的Controller层测试类
 * @author 树朾
 * @date 2015-08-24 11:35:56 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class DsDeployControllerTester {

	@Autowired
	DsDeployController controller;
	
	@Test
	public void findByAppId() throws Exception{
		Object result = controller.findByAppId("1", "1");
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void add() throws Exception{
		DsDeploy model = new DsDeploy();
		Object result = controller.add(model);
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void update() throws Exception {
		DsDeploy model = new DsDeploy();
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
