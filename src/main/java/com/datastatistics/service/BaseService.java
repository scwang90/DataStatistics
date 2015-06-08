package com.datastatistics.service;

import com.datastatistics.dao.base.BaseDao;
import com.datastatistics.util.Page;

public interface BaseService<T> extends BaseDao<T>{
	public int delete(String id) throws Exception;
	public T findById(String id) throws Exception;
	public Page<T> listByPage(int pageSize, int pageNo) throws Exception;
}
