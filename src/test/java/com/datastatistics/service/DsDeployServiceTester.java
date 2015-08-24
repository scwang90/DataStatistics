package com.datastatistics.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datastatistics.model.DsDeploy;
import com.datastatistics.util.JacksonUtil;

/**
 * 数据库表ds_deploy的Service层测试类
 * @author 树朾
 * @date 2015-08-24 11:35:56 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class DsDeployServiceTester {

	@Autowired
	DsDeployService service;
	
	@Test
	public void insert() throws Exception{
		DsDeploy model = new DsDeploy();
		Object result = service.insert(model);
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void update() throws Exception {
		DsDeploy model = new DsDeploy();
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


	@Test
	public void findByPage() throws Exception {
		Object result = service.findByPage(5, 0);
		System.out.println(JacksonUtil.toJson(result));
	}
	
}
