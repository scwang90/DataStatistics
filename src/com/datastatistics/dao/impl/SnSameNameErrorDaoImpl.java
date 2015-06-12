package com.datastatistics.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datastatistics.dao.base.BaseDaoImpl;
import com.datastatistics.dao.SnSameNameErrorDao;
import com.datastatistics.model.SnSameNameError;
/**
 * 数据库表sn_same_name_error的Dao实现
 * @author 树朾
 * @date 2015-06-12 17:21:15 中国标准时间     
 */
@Repository
public class SnSameNameErrorDaoImpl extends BaseDaoImpl<SnSameNameError> implements SnSameNameErrorDao{

	@Override
	public int insert(SnSameNameError t) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(t);
	}

	@Override
	public int update(SnSameNameError t) throws Exception {
		// TODO Auto-generated method stub
		return super.update(t);
	}

	@Override
	public int delete(Object id) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return super.countAll();
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
	public List<SnSameNameError> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}
}

