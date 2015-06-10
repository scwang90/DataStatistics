package com.datastatistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.dao.base.MultiDao;
import com.datastatistics.model.SnSameName;
import com.datastatistics.service.SnSameNameService;
import com.datastatistics.util.Page;
import com.datastatistics.util.ServiceException;

/**
 * 数据库表sn_same_name的Service接实现
 * @author 树朾
 * @date 2015-06-09 02:10:52 中国标准时间     
 */
@Service
public class SnSameNameServiceImpl extends BaseServiceImpl<SnSameName> implements SnSameNameService{

	@Autowired
	MultiDao<SnSameName> snSameNameDaoImpl;

	/**
	 * 添加 同名数据的时候先检测使用已经存在同名数据
	 * 如果存在，取出老数据，比对结果如果一样返回1代表成功，不一样0代表失败，
	 * 如果不存在 直接添加数据 
	 */
	@Override
	public int insert(SnSameName model) throws Exception {
		// TODO Auto-generated method stub
		List<SnSameName> list = snSameNameDaoImpl.findByPropertyName("sameName", model.getSameName());
		for (SnSameName sameName : list) {
			return sameName.getSameName().equals(model.getSameName())?1:0;
		}
		return super.insert(model);
	}

	@Override
	public int update(SnSameName model) throws Exception {
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
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<SnSameName> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}

	@Override
	public SnSameName findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Page<SnSameName> listByPage(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		return super.listByPage(pageSize, pageNo);
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return super.countAll();
	}
	
}
