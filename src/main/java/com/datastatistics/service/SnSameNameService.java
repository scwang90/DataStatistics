package com.datastatistics.service;

import com.datastatistics.model.SnSameName;

/**
 * 数据库表sn_same_name的Service接口层
 * @author Administrator
 */
public interface SnSameNameService extends BaseService<SnSameName>{

	/**
	 * 客户端查询结果提交
	 * @param name 查询名称
	 * @param value 查询结果
	 * @throws Exception
	 */
	public void submit(String name, String value) throws Exception;

}
