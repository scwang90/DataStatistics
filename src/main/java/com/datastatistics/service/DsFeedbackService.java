package com.datastatistics.service;

import java.util.List;

import com.datastatistics.model.DsFeedback;

/**
 * 数据库表ds_feedback的Service接口层
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
public interface DsFeedbackService extends BaseService<DsFeedback>{

	/**
	 * 插入一条新数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(DsFeedback model) throws Exception;
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
	public int update(DsFeedback model) throws Exception;
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
	public DsFeedback findById(Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return
	 * @throws Exception
	 */
	public List<DsFeedback> findAll() throws Exception;
	/**
	 * 分页查询数据
	 * @param limit
	 * @param start
	 * @return
	 * @throws Exception
	 */
	public List<DsFeedback> findByPage(int limit,int start) throws Exception;
	
}
