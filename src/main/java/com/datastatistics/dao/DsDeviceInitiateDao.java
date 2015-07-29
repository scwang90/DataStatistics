package com.datastatistics.dao;

import java.util.List;

import com.datastatistics.dao.base.BaseDao;
import com.datastatistics.model.DsDeviceInitiate;

/**
 * 数据库表ds_device_initiate的Dao接口
 * @author 树朾
 * @date 2015-07-29 22:55:47 中国标准时间
 */
public interface DsDeviceInitiateDao extends BaseDao<DsDeviceInitiate>{

	/**
	 * 插入一条新数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(DsDeviceInitiate model) throws Exception;
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
	public int update(DsDeviceInitiate model) throws Exception;
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
	public DsDeviceInitiate findById(Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return
	 * @throws Exception
	 */
	public List<DsDeviceInitiate> findAll() throws Exception;
	/**
	 * 分页查询数据
	 * @param limit
	 * @param start
	 * @return
	 * @throws Exception
	 */
	public List<DsDeviceInitiate> findByPage(int limit,int start) throws Exception;
	

}
