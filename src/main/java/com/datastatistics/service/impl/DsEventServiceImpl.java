package com.datastatistics.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.util.Page;
import com.datastatistics.util.ServiceException;
import com.datastatistics.dao.DsEventDao;
import com.datastatistics.model.DsEvent;
import com.datastatistics.service.DsEventService;

/**
 * 数据库表ds_event的Service接实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Service
public class DsEventServiceImpl extends BaseServiceImpl<DsEvent> implements DsEventService{

	@Autowired
	DsEventDao dao;
	
	@Override
	public int insert(DsEvent model) throws Exception{
		// TODO Auto-generated method stub
//		checkNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(DsEvent model) throws Exception {
		// TODO Auto-generated method stub
		DsEvent old = findById(getModelID(model));
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
	public DsEvent findById(Object id) throws Exception{
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<DsEvent> findAll() throws Exception{
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<DsEvent> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByPage(limit,start);
	}

	@Override
	public DsEvent findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	
	@Override
	public Page<DsEvent> listByPage(int pageSize, int pageNo) throws Exception{
		// TODO Auto-generated method stub
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1+totalRecord/pageSize;
		
		List<DsEvent> list = dao.findByPage(limit, start);
		
		return new Page<DsEvent>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.countAll();
	}
}
