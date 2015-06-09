package com.datastatistics.dao.base;

import java.util.List;
/**
 * 通用Dao层接口
 * @param <T>
 * @author 树朾
 * @date 2015-06-10 02:46:08 中国标准时间 
 */
public interface BaseDao<T> {

	public int insert(T model) throws Exception;
	public int delete(Object id) throws Exception;
	public int update(T model) throws Exception;
	public int countAll() throws Exception;
	public T findById(Object id) throws Exception;
	public List<T> findAll() throws Exception;
	public List<T> findByPage(int limit,int start) throws Exception;
	
}
