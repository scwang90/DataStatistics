package com.datastatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastatistics.annotations.Intent;
import com.datastatistics.controller.base.GeneralController;
import com.datastatistics.model.DsDeploy;
import com.datastatistics.service.DsDeployService;

/**
 * 数据库表ds_deploy 的Controller层实现
 * @author 树朾
 * @date 2015-08-24 11:35:55 中国标准时间
 */	
@RestController
@Intent("数据库表ds_deploy")
@RequestMapping("DsDeploy")
public class DsDeployController extends GeneralController<DsDeploy>{

	@Autowired
	DsDeployService service;
	
	@RequestMapping("findByAppId/{appkey}")
	public Object findByAppId(@RequestHeader("token") String token,@PathVariable String appkey) throws Exception{
		return service.findByAppId(appkey);
	}
	
	/**
	 * 添加信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("Add")
	public Object add(@RequestHeader("token") String token,@RequestBody DsDeploy model) throws Exception {
		// TODO Auto-generated method stub
		service.insert(model);
		return null;
	}

	/**
	 * 更新信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("Update")
	public Object update(@RequestHeader("token") String token,@RequestBody DsDeploy model) throws Exception {
		// TODO Auto-generated method stub
		service.update(model);
		return null;
	}

	/**
	 * 根据ID获取信息
	 * @param ID
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("Get/{ID}")
	public Object getByID(@RequestHeader("token") String token,@PathVariable String ID) throws Exception {
		// TODO Auto-generated method stub
		Object model = service.findById(ID);
		if (model == null) {
			return "null";
		}
		return model;
	}

	/**
	 * 根据ID删除
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("Delete/{ID}")
	public Object delete(@RequestHeader("token") String token,@PathVariable String ID) throws Exception {
		// TODO Auto-generated method stub
		service.delete(ID);
		return null;
	}

	/**
	 * 统计全部
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("CountAll")
	public Object countAll(@RequestHeader("token") String token) throws Exception {
		// TODO Auto-generated method stub
		return service.countAll();
	}

	/**
	 * 获取全部列表
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("GetList")
	public Object getList(@RequestHeader("token") String token) throws Exception {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	/**
	 * 获取分页列表
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("GetList/{pageSize}/{pageNo}")
	public Object getListByPage(@RequestHeader("token") String token,@PathVariable int pageSize,@PathVariable int pageNo) throws Exception {
		// TODO Auto-generated method stub
		return service.listByPage(pageSize, pageNo);
	}

}
