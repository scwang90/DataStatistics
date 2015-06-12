package com.datastatistics.service;

import com.datastatistics.dao.base.BaseDao;
import com.datastatistics.util.Page;

/**
 * 通用Service层接口
 * @param <T>
 * @author 树朾
 * @date 2015-06-12 17:21:15 中国标准时间 
 */
public interface BaseService<T> extends BaseDao<T>{
	public int delete(String id) throws Exception;
	public T findById(String id) throws Exception;
	public Page<T> listByPage(int pageSize, int pageNo) throws Exception;
}
