package com.datastatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastatistics.annotations.Intent;
import com.datastatistics.controller.base.StatisticsController;
import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsDevice;
import com.datastatistics.service.DsDeviceService;

/**
 * 数据库表ds_device 的Controller层实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@RestController
@Intent("数据库表ds_device")
@RequestMapping("DsDevice")
public class DsDeviceController extends StatisticsController<DsDevice>{

	@Autowired
	DsDeviceService service;

	/**
	 * 设备启动统计
	 * @param model
	 * @param channel
	 */
	@RequestMapping("InitDevice/{channel}")
	public Object initDevice(@RequestHeader("token") String token,@RequestBody DsDevice model,@PathVariable String channel) throws Exception {
		// TODO Auto-generated method stub
		DsApplication application = super.verifyAppKey(model.getAppId());
		service.initDevice(model,application,channel);
		return null;
	}
	/**
	 * 设备关闭统计
	 * @param model
	 * @param application
	 * @param channel
	 */
	@RequestMapping("Uninstall/{channel}")
	public Object uninstall(@RequestHeader("token") String token,@RequestBody DsDevice model,@PathVariable String channel) throws Exception {
		// TODO Auto-generated method stub
		DsApplication application = super.verifyAppKey(model.getAppId());
		service.uninstall(model,application,channel);
		return null;
	}
	
}
