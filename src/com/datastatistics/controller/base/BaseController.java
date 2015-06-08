package com.datastatistics.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

/**
 * Controller 层基类
 * @author 树朾
 * @date 2015-06-09 01:44:14 中国标准时间 
 */
public class BaseController {
	
	protected void bindModel(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
//		String title = "XXX后台管理系统";
//		model.addAttribute("title", title);
	}

//	protected String success(Object message){
//		return ResultUtil.getSuccess(message);
//	}
//	
//	protected String failure(Object message){
//		return ResultUtil.getFailure(message);
//	}
}
