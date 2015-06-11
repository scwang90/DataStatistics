package com.datastatistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.dao.base.MultiDao;
import com.datastatistics.model.SnQueryCount;
import com.datastatistics.model.SnSameName;
import com.datastatistics.service.SnQueryCountService;
import com.datastatistics.util.Page;
import com.datastatistics.util.ServiceException;

/**
 * 数据库表sn_query_count的Service接实现
 * @author 树朾
 * @date 2015-06-09 02:10:52 中国标准时间     
 */
@Service
public class SnQueryCountServiceImpl extends BaseServiceImpl<SnQueryCount> implements SnQueryCountService{

	@Autowired
	MultiDao<SnQueryCount> snQueryCountDaoImpl;
	
	@Autowired
	MultiDao<SnSameName> snSameNameDaoImpl;

	@Override
	public void countQuery(SnSameName model) throws Exception {
		// TODO Auto-generated method stub
		List<SnSameName> names = snSameNameDaoImpl.findByPropertyName("sameName", model.getSameName());
		for (SnSameName name : names) {
			List<SnQueryCount> list = snQueryCountDaoImpl.findByPropertyName("sameName", name.getSameName());
			for (SnQueryCount count : list) {
				count.setCount(count.getCount()+1);
				super.update(count);
				return;
			}
			SnQueryCount count = SnQueryCount.from(name);
			count.setCount(1);
			super.insert(count);
			return ;
		}
	}
	
	@Override
	public int insert(SnQueryCount model) throws Exception {
		// TODO Auto-generated method stub
		throw new ServiceException("添加 方法被关闭");
		//return super.insert(model);
	}

	@Override
	public int update(SnQueryCount model) throws Exception {
		// TODO Auto-generated method stub
		throw new ServiceException("更新 方法被关闭");
		//return super.update(model);
	}

	@Override
	public int delete(Object model) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(model);
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
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<SnQueryCount> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}

	@Override
	public SnQueryCount findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Page<SnQueryCount> listByPage(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		return super.listByPage(pageSize, pageNo);
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return super.countAll();
	}
	
}
