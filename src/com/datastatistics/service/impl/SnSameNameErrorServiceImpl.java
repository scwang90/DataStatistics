package com.datastatistics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datastatistics.model.SnSameNameError;
import com.datastatistics.service.SnSameNameErrorService;
import com.datastatistics.util.Page;

/**
 * 数据库表sn_same_name_error的Service接实现
 * @author 树朾
 * @date 2015-06-10 02:46:08 中国标准时间     
 */
@Service
public class SnSameNameErrorServiceImpl extends BaseServiceImpl<SnSameNameError> implements SnSameNameErrorService{

	@Override
	public int insert(SnSameNameError model) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(model);
	}

	@Override
	public int update(SnSameNameError model) throws Exception {
		// TODO Auto-generated method stub
		return super.update(model);
	}

	@Override
	public int delete(Object model) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(model);
	}

	@Override
	public SnSameNameError findById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<SnSameNameError> findAll() throws Exception {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<SnSameNameError> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}

	@Override
	public SnSameNameError findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Page<SnSameNameError> listByPage(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		return super.listByPage(pageSize, pageNo);
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return super.countAll();
	}
	
}
