package com.datastatistics.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.util.Page;
import com.datastatistics.util.ServiceException;
import com.datastatistics.dao.DsDeviceInitiateDao;
import com.datastatistics.model.DsDeviceInitiate;
import com.datastatistics.service.DsDeviceInitiateService;

/**
 * 数据库表ds_device_initiate的Service接实现
 * @author 树朾
 * @date 2015-07-29 22:55:48 中国标准时间
 */
@Service
public class DsDeviceInitiateServiceImpl extends BaseServiceImpl<DsDeviceInitiate> implements DsDeviceInitiateService{

	@Autowired
	DsDeviceInitiateDao dao;
	
	@Override
	public int insert(DsDeviceInitiate model) throws Exception{
		// TODO Auto-generated method stub
//		checkNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(DsDeviceInitiate model) throws Exception {
		// TODO Auto-generated method stub
		DsDeviceInitiate old = findById(getModelID(model));
		if (old == null) {
			throw new ServiceException("请求更新记录不存在或已经被删除！");
		}
		model = checkNullField(old, model);
		return dao.update(model);
	}

	@Override
	public int delete(Object id) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public DsDeviceInitiate findById(Object id) throws Exception{
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<DsDeviceInitiate> findAll() throws Exception{
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<DsDeviceInitiate> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByPage(limit,start);
	}

	@Override
	public DsDeviceInitiate findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	
	@Override
	public Page<DsDeviceInitiate> listByPage(int pageSize, int pageNo) throws Exception{
		// TODO Auto-generated method stub
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1+totalRecord/pageSize;
		
		List<DsDeviceInitiate> list = dao.findByPage(limit, start);
		
		return new Page<DsDeviceInitiate>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.countAll();
	}
}
