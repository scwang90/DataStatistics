package com.datastatistics.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.util.Page;
import com.datastatistics.util.ServiceException;
import com.datastatistics.dao.DsDeviceDao;
import com.datastatistics.model.DsDevice;
import com.datastatistics.service.DsDeviceService;

/**
 * 数据库表ds_device的Service接实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Service
public class DsDeviceServiceImpl extends BaseServiceImpl<DsDevice> implements DsDeviceService{

	@Autowired
	DsDeviceDao dao;
	
	@Override
	public int insert(DsDevice model) throws Exception{
		// TODO Auto-generated method stub
//		checkNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(DsDevice model) throws Exception {
		// TODO Auto-generated method stub
		DsDevice old = findById(getModelID(model));
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
	public DsDevice findById(Object id) throws Exception{
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<DsDevice> findAll() throws Exception{
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<DsDevice> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByPage(limit,start);
	}

	@Override
	public DsDevice findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	
	@Override
	public Page<DsDevice> listByPage(int pageSize, int pageNo) throws Exception{
		// TODO Auto-generated method stub
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1+totalRecord/pageSize;
		
		List<DsDevice> list = dao.findByPage(limit, start);
		
		return new Page<DsDevice>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.countAll();
	}
}
