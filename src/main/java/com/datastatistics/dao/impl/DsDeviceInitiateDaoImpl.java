package com.datastatistics.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datastatistics.dao.base.BaseDaoImpl;
import com.datastatistics.dao.DsDeviceInitiateDao;
import com.datastatistics.model.DsDeviceInitiate;

/**
 * 数据库表ds_device_initiate的Dao实现
 * @author 树朾
 * @date 2015-07-29 22:55:47 中国标准时间
 */
@Repository
public class DsDeviceInitiateDaoImpl extends BaseDaoImpl<DsDeviceInitiate> implements DsDeviceInitiateDao{

	@Override
	public int insert(DsDeviceInitiate t) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(t);
	}

	@Override
	public int update(DsDeviceInitiate t) throws Exception {
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
	public DsDeviceInitiate findById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<DsDeviceInitiate> findAll() throws Exception {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public List<DsDeviceInitiate> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}
}

