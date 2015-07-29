package com.datastatistics.service;

import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsDevice;

/**
 * 数据库表ds_device的Service接口层
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
public interface DsDeviceService extends BaseService<DsDevice>{

	/**
	 * 设备启动统计
	 * @param model
	 * @param application
	 * @param channel
	 */
	public void initDevice(DsDevice model, DsApplication application,String channel) throws Exception;
	/**
	 * 设备关闭统计
	 * @param model
	 * @param application
	 * @param channel
	 */
	public void uninstall(DsDevice model, DsApplication application,String channel) throws Exception;
	
}
