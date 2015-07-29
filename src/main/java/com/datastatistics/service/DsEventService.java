package com.datastatistics.service;

import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsEvent;

/**
 * 数据库表ds_event的Service接口层
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
public interface DsEventService extends BaseService<DsEvent>{

	/**
	 * 应用触发事件统计
	 * @param model
	 * @param application
	 */
	public void triggerEvent(DsEvent model, DsApplication application) throws Exception;
	
}
