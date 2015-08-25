package com.datastatistics.dao;

import java.util.List;

import com.datastatistics.dao.base.BaseDao;
import com.datastatistics.model.DsDeploy;

/**
 * 数据库表ds_deploy的Dao接口
 * @author 树朾
 * @date 2015-08-24 11:35:56 中国标准时间
 */
public interface DsDeployDao extends BaseDao<DsDeploy>{

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
	/**
	 * 获取指定 appkey 的配置列表
	 * @param appkey
	 * @return
	 * @throws Exception
	 */
	public List<DsDeploy> findByAppId(String appkey) throws Exception;

}
