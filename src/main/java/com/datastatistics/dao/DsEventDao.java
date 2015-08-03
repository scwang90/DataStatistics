package com.datastatistics.dao;

import java.util.List;

import com.datastatistics.dao.base.BaseDao;
import com.datastatistics.model.DsEvent;

/**
 * 数据库表ds_event的Dao接口
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
public interface DsEventDao extends BaseDao<DsEvent>{

	/**
	 * 插入一条新数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(DsEvent model) throws Exception;
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Object id) throws Exception;
	/**
	 * 更新一条数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int update(DsEvent model) throws Exception;
	/**
	 * 统计全部出数据
	 * @return
	 * @throws Exception
	 */
	public int countAll() throws Exception;
	/**
	 * 根据ID获取
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DsEvent findById(Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return
	 * @throws Exception
	 */
	public List<DsEvent> findAll() throws Exception;
	/**
	 * 分页查询数据
	 * @param limit
	 * @param start
	 * @return
	 * @throws Exception
	 */
	public List<DsEvent> findByPage(int limit,int start) throws Exception;
	/**
	 * 获取当时 uniqueId 启动 的记录
	 * @param uniqueId
	 * @return
	 */
	public List<DsEvent> findByUniqueIdHour(String uniqueId) throws Exception;
	

}
