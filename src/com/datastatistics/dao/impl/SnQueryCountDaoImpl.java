package com.datastatistics.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datastatistics.dao.base.BaseDaoImpl;
import com.datastatistics.dao.SnQueryCountDao;
import com.datastatistics.model.SnQueryCount;
/**
 * 数据库表sn_query_count的Dao实现
 * @author 树朾
 * @date 2015-06-11 13:42:12 中国标准时间     
 */
@Repository
public class SnQueryCountDaoImpl extends BaseDaoImpl<SnQueryCount> implements SnQueryCountDao{

	@Override
	public int insert(SnQueryCount t) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(t);
	}

	@Override
	public int update(SnQueryCount t) throws Exception {
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
	public List<SnQueryCount> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}
}

