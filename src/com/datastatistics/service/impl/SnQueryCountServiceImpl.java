package com.datastatistics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datastatistics.model.SnQueryCount;
import com.datastatistics.service.SnQueryCountService;
import com.datastatistics.util.Page;

/**
 * 数据库表sn_query_count的Service接实现
 * @author 树朾
 * @date 2015-06-09 02:10:52 中国标准时间     
 */
@Service
public class SnQueryCountServiceImpl extends BaseServiceImpl<SnQueryCount> implements SnQueryCountService{

	@Override
	public int insert(SnQueryCount model) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(model);
	}

	@Override
	public int update(SnQueryCount model) throws Exception {
		// TODO Auto-generated method stub
		return super.update(model);
	}

	@Override
	public int delete(Object model) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(model);
	}

	@Override
	public SnQueryCount findById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<SnQueryCount> findAll() throws Exception {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<SnQueryCount> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}

	@Override
	public SnQueryCount findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Page<SnQueryCount> listByPage(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		return super.listByPage(pageSize, pageNo);
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return super.countAll();
	}
	
}
