package com.datastatistics.service;

import com.datastatistics.model.SnSameName;
import com.datastatistics.model.SnSameNameError;

/**
 * 数据库表sn_same_name_error的Service接口层
 * @author 树朾
 * @date 2015-06-09 02:10:52 中国标准时间     
 */
public interface SnSameNameErrorService extends BaseService<SnSameNameError>{

	/**
	 * 添加同名错误 错误信息
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public void error(SnSameName model) throws Exception;
	
}
