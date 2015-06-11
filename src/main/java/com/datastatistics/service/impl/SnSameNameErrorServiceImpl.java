package com.datastatistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.dao.base.MultiDao;
import com.datastatistics.model.SnSameName;
import com.datastatistics.model.SnSameNameError;
import com.datastatistics.service.SnSameNameErrorService;
import com.datastatistics.util.Page;
import com.datastatistics.util.ServiceException;

/**
 * 数据库表sn_same_name_error的Service接实现
 * @author 树朾
 * @date 2015-06-09 02:10:52 中国标准时间     
 */
@Service
public class SnSameNameErrorServiceImpl extends BaseServiceImpl<SnSameNameError> implements SnSameNameErrorService{

	@Autowired
	MultiDao<SnSameNameError> snSameNameErrorDaoImpl;
	
	@Override
	public void error(SnSameName model) throws Exception {
		// TODO Auto-generated method stub
		SnSameNameError error = SnSameNameError.from(model);
		List<SnSameNameError> list = snSameNameErrorDaoImpl.findByPropertyName("sameName", model.getSameName());
		for (SnSameNameError count : list) {
			if (count.getCountProvince().equals(model.getCountProvince())) {
				count.setCount(count.getCount()+1);
				super.update(count);
				return;
			}
		}
		error.setCount(1);
		super.insert(error);
	}

	
	@Override
	public int insert(SnSameNameError model) throws Exception {
		// TODO Auto-generated method stub
		throw new ServiceException("添加 方法被关闭");
		//return super.insert(model);
	}

	@Override
	public int update(SnSameNameError model) throws Exception {
		// TODO Auto-generated method stub
		throw new ServiceException("更新 方法被关闭");
		//return super.update(model);
	}
	
	@Override
	public SnSameNameError findById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<SnSameNameError> findAll() throws Exception {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<SnSameNameError> findByPage(int limit, int start) throws Exception {
		// TODO Auto-generated method stub
		return super.findByPage(limit, start);
	}

	@Override
	public SnSameNameError findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Page<SnSameNameError> listByPage(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		return super.listByPage(pageSize, pageNo);
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return super.countAll();
	}
	
}
