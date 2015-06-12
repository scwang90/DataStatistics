package com.datastatistics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datastatistics.model.SnProvince;
import com.datastatistics.service.SnProvinceService;
import com.datastatistics.util.Page;

/**
 * 数据库表sn_province的Service接实现
 * @author 树朾
 * @date 2015-06-12 17:21:15 中国标准时间     
 */
@Service
public class SnProvinceServiceImpl extends BaseServiceImpl<SnProvince> implements SnProvinceService{

	@Override
	public int insert(SnProvince model) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(model);
	}

	@Override
	public int update(SnProvince model) throws Exception {
		// TODO Auto-generated method stub
		return super.update(model);
	}

	@Override
	public int delete(Object id) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public SnProvince findById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<SnProvince> findAll() throws Exception {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<SnProvince> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}

	@Override
	public SnProvince findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Page<SnProvince> listByPage(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		return super.listByPage(pageSize, pageNo);
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return super.countAll();
	}
	
}
