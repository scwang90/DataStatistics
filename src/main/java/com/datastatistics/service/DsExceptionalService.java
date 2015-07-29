package com.datastatistics.service;

import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsExceptional;

/**
 * 数据库表ds_exceptional的Service接口层
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
public interface DsExceptionalService extends BaseService<DsExceptional>{

	/**
	 * 应用异常统计
	 * @param model
	 * @return
	 */
	public void exceptional(DsExceptional model,DsApplication application) throws Exception;
	
}
