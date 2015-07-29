package com.datastatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastatistics.annotations.Intent;
import com.datastatistics.controller.base.StatisticsController;
import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsExceptional;
import com.datastatistics.service.DsExceptionalService;

/**
 * 数据库表ds_exceptional 的Controller层实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@RestController
@Intent("数据库表ds_exceptional")
@RequestMapping("DsExceptional")
public class DsExceptionalController extends StatisticsController<DsExceptional>{

	@Autowired
	DsExceptionalService service;
	
	/**
	 * 应用异常统计
	 * @param model
	 * @return
	 */
	@RequestMapping("Exceptional")
	public Object exceptional(@RequestBody DsExceptional model) throws Exception {
		// TODO Auto-generated method stub
		DsApplication application = super.verifyAppKey(model.getAppId());
		service.exceptional(model,application);
		return null;
	}

}
