package com.datastatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastatistics.annotations.Intent;
import com.datastatistics.controller.base.StatisticsController;
import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsEvent;
import com.datastatistics.service.DsEventService;

/**
 * 数据库表ds_event 的Controller层实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@RestController
@Intent("数据库表ds_event")
@RequestMapping("DsEvent")
public class DsEventController extends StatisticsController<DsEvent>{

	@Autowired
	DsEventService service;
	
	/**
	 * 应用触发事件统计
	 * @param model
	 */
	@RequestMapping("TriggerEvent")
	public Object triggerEvent(@RequestHeader("token") String token,@RequestBody DsEvent model) throws Exception {
		// TODO Auto-generated method stub
		DsApplication application = super.verifyAppKey(model.getAppId());
		service.triggerEvent(model,application);
		return null;
	}
	
}
