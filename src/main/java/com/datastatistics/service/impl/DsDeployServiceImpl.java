package com.datastatistics.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.util.Page;
import com.datastatistics.util.ServiceException;
import com.datastatistics.dao.DsDeployDao;
import com.datastatistics.model.DsDeploy;
import com.datastatistics.service.DsDeployService;

/**
 * 数据库表ds_deploy的Service接实现
 * @author 树朾
 * @date 2015-08-24 11:35:56 中国标准时间
 */
@Service
public class DsDeployServiceImpl extends BaseServiceImpl<DsDeploy> implements DsDeployService{

	@Autowired
	DsDeployDao dao;
	
	@Override
	public int insert(DsDeploy model) throws Exception{
		// TODO Auto-generated method stub
		return dao.insert(model);
	}
	
	@Override
	public int update(DsDeploy model) throws Exception {
		// TODO Auto-generated method stub
		DsDeploy old = findById(getModelID(model));
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
	public DsDeploy findById(Object id) throws Exception{
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<DsDeploy> findAll() throws Exception{
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<DsDeploy> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByPage(limit,start);
	}

	@Override
	public DsDeploy findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	
	@Override
	public Page<DsDeploy> listByPage(int pageSize, int pageNo) throws Exception{
		// TODO Auto-generated method stub
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1+totalRecord/pageSize;
		
		List<DsDeploy> list = dao.findByPage(limit, start);
		
		return new Page<DsDeploy>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.countAll();
	}

	@Override
	public List<DsDeploy> findByAppId(String appkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByAppId(appkey);
	}
}
