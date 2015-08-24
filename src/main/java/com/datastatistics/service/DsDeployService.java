package com.datastatistics.service;

import java.util.List;

import com.datastatistics.model.DsDeploy;

/**
 * 数据库表ds_deploy的Service接口层
 * @author 树朾
 * @date 2015-08-24 11:35:56 中国标准时间
 */
public interface DsDeployService extends BaseService<DsDeploy>{

	/**
	 * 插入一条新数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(DsDeploy model) throws Exception;
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
	public int update(DsDeploy model) throws Exception;
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
	public DsDeploy findById(Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return
	 * @throws Exception
	 */
	public List<DsDeploy> findAll() throws Exception;
	/**
	 * 分页查询数据
	 * @param limit
	 * @param start
	 * @return
	 * @throws Exception
	 */
	public List<DsDeploy> findByPage(int limit, int start) throws Exception;
	
}
