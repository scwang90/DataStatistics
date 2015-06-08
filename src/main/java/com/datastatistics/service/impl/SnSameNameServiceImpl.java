package com.datastatistics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datastatistics.model.SnSameName;
import com.datastatistics.service.SnSameNameService;
import com.datastatistics.util.Page;

/**
 * 数据库表sn_same_name的Service接实现
 * @author Administrator
 */
@Service
public class SnSameNameServiceImpl extends BaseServiceImpl<SnSameName> implements SnSameNameService{

	@Override
	public void submit(String name, String value) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int insert(SnSameName model) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(model);
	}

	@Override
	public int update(SnSameName model) throws Exception {
		// TODO Auto-generated method stub
		return super.update(model);
	}

	@Override
	public int delete(Object model) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(model);
	}

	@Override
	public SnSameName findById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<SnSameName> findAll() throws Exception {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<SnSameName> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}

	@Override
	public SnSameName findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Page<SnSameName> listByPage(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		return super.listByPage(pageSize, pageNo);
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return super.countAll();
	}
	
}
