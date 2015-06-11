package com.datastatistics.service;

import java.util.List;

import com.datastatistics.model.SnSameName;
import com.datastatistics.model.entity.SameName;

/**
 * 数据库表sn_same_name的Service接口层
 * @author 树朾
 * @date 2015-06-09 02:10:52 中国标准时间     
 */
public interface SnSameNameService extends BaseService<SnSameName>{

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int post(SnSameName model) throws Exception;
	/**
	 * 查询同名数据
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<SameName> query(String name) throws Exception;


}
