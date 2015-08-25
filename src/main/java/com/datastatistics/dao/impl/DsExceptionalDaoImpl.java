package com.datastatistics.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datastatistics.dao.base.BaseDaoImpl;
import com.datastatistics.dao.DsExceptionalDao;
import com.datastatistics.model.DsExceptional;

/**
 * 数据库表ds_exceptional的Dao实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Repository
public class DsExceptionalDaoImpl extends BaseDaoImpl<DsExceptional> implements DsExceptionalDao{

	@Override
	public int insert(DsExceptional t) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(t);
	}

	@Override
	public int update(DsExceptional t) throws Exception {
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
	public DsExceptional findById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<DsExceptional> findAll() throws Exception {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public List<DsExceptional> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}

	@Override
	public DsExceptional findBySimple(DsExceptional model) throws Exception {
		// TODO Auto-generated method stub
		String where = "WHERE appId='%s' and name='%s' and message='%s' and platform='%s' and channel='%s'";
		where = String.format(where, model.getAppId(),model.getName(),model.getMessage(),model.getPlatform(),model.getChannel());
		for (DsExceptional exceptional : findWhere(where)) {
			return exceptional;
		}
		return null;
	}
}

