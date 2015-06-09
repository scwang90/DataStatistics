package com.datastatistics.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datastatistics.dao.base.BaseDaoImpl;
import com.datastatistics.dao.SnSameNameDao;
import com.datastatistics.model.SnSameName;
/**
 * 数据库表sn_same_name的Dao实现
 * @author 树朾
 * @date 2015-06-10 02:46:08 中国标准时间     
 */
@Repository
public class SnSameNameDaoImpl extends BaseDaoImpl<SnSameName> implements SnSameNameDao{

	@Override
	public int insert(SnSameName t) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(t);
	}

	@Override
	public int update(SnSameName t) throws Exception {
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
	public List<SnSameName> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}
}

