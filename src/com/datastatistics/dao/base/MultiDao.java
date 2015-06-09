package com.datastatistics.dao.base;

import java.util.List;
/**
 * 多功能Dao层接口
 * @param <T>
 * @author 树朾
 * @date 2015-06-10 02:46:08 中国标准时间 
 */
public interface MultiDao<T> extends BaseDao<T>{

	public int deleteWhere(String where) throws Exception ;
	public int deleteByPropertyName(String propertyName,Object value) throws Exception;
	public int countWhere(String where) throws Exception;
	public int countByPropertyName(String propertyName,Object value) throws Exception ;
	public List<T> findWhere( String where) throws Exception ;
	public List<T> findWhereByPage(String where, int limit,int start) throws Exception;
	public List<T> findByPropertyName(String propertyName,Object value) throws Exception;

}
