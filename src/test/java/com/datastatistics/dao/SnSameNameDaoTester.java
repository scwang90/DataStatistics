package com.datastatistics.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datastatistics.model.SnSameName;
import com.datastatistics.util.JacksonUtil;

/**
 * 数据库表sn_same_name的Dao层测试类
 * @author 树朾
 * @date 2015-07-28 23:44:11 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class SnSameNameDaoTester {

	@Autowired
	SnSameNameDao dao;
	
	@Test
	public void insert() throws Exception{
		SnSameName model = new SnSameName();
		Object result = dao.insert(model);
		System.out.println(JacksonUtil.toJson(result));
	}
	
	@Test
	public void update() throws Exception {
		SnSameName model = new SnSameName();
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
	
	
}
