package com.datastatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastatistics.annotations.Intent;
import com.datastatistics.controller.base.StatisticsController;
import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsFeedback;
import com.datastatistics.service.DsFeedbackService;

/**
 * 数据库表ds_feedback 的Controller层实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@RestController
@Intent("数据库表ds_feedback")
@RequestMapping("DsFeedback")
public class DsFeedbackController extends StatisticsController<DsFeedback>{

	@Autowired
	DsFeedbackService service;
	
	/**
	 * 应用反馈信息统计
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("Feedback")
	public Object feedback(@RequestHeader("token") String token,@RequestBody DsFeedback model) throws Exception {
		// TODO Auto-generated method stub
		DsApplication application = super.verifyAppKey(model.getAppId());
		service.feedback(model,application);
		return null;
	}

}
