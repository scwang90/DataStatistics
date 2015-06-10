package com.datastatistics.service;

import com.datastatistics.model.SnQueryCount;
import com.datastatistics.model.SnSameName;

/**
 * 数据库表sn_query_count的Service接口层
 * @author 树朾
 * @date 2015-06-09 02:10:52 中国标准时间     
 */
public interface SnQueryCountService extends BaseService<SnQueryCount>{

	/**
	 * 统计查询 SnSameName 
	 * @param model
	 * @throws Exception
	 */
	public void countQuery(SnSameName model) throws Exception;

}
