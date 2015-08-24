package com.datastatistics.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datastatistics.dao.base.BaseDaoImpl;
import com.datastatistics.dao.DsDeployDao;
import com.datastatistics.model.DsDeploy;

/**
 * 数据库表ds_deploy的Dao实现
 * @author 树朾
 * @date 2015-08-24 11:35:56 中国标准时间
 */
@Repository
public class DsDeployDaoImpl extends BaseDaoImpl<DsDeploy> implements DsDeployDao{

	@Override
	public int insert(DsDeploy t) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(t);
	}

	@Override
	public int update(DsDeploy t) throws Exception {
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
	public DsDeploy findById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<DsDeploy> findAll() throws Exception {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public List<DsDeploy> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}
}

