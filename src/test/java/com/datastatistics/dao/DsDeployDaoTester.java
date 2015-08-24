package com.datastatistics.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datastatistics.model.DsDeploy;
import com.datastatistics.util.JacksonUtil;

import java.util.Date;

/**
 * 数据库表ds_deploy的Dao层测试类
 * @author 树朾
 * @date 2015-08-24 11:35:56 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class DsDeployDaoTester {

	@Autowired
	DsDeployDao dao;
	
	@Test
	public void insert() throws Exception{
		DsDeploy model = new DsDeploy();
		model.setAppId("1");
		model.setName("");
		model.setRemark("");
		model.setUrls("");
		model.setVersion("");
		model.setBusiness(true);
		Object result = dao.insert(model);
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void update() throws Exception {
		DsDeploy model = new DsDeploy();
		model.setKeyId("d5b225b7-8392-470d-b363-eb1820afe859");
		model.setAppId("1");
		model.setName("22222");
		model.setRemark("");
		model.setUrls("");
		model.setVersion("");
		model.setBusiness(true);
		model.setCreateTime(new Date());
		Object result = dao.update(model);
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void delete() throws Exception {
		Object result = dao.delete("1");
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void countAll() throws Exception {
		Object result = dao.countAll();
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void findByPage() throws Exception {
		Object result = dao.findByPage(5,0);
		System.out.println(JacksonUtil.toJson(result));
	}
}
