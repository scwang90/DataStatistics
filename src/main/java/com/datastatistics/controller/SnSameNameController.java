package com.datastatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastatistics.annotations.Intent;
import com.datastatistics.controller.base.GeneralController;
import com.datastatistics.model.SnSameName;
import com.datastatistics.service.SnQueryCountService;
import com.datastatistics.service.SnSameNameErrorService;
import com.datastatistics.service.SnSameNameService;

/**
 * 数据库表sn_same_name 的Controller层实现
 * @author 树朾
 * @date 2015-06-09 02:10:51 中国标准时间     
 */
@RestController
@Intent("同名")
@RequestMapping("SnSameName")
public class SnSameNameController extends GeneralController<SnSameName>{

	@Autowired
	SnSameNameService service;
	
	@Autowired
	SnSameNameErrorService errorService;
	
	@Autowired
	SnQueryCountService countService;
	
	
	/**
	 * 查询同名数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@Intent("查询%s")
	@RequestMapping("Query/{name}")
	public Object query(@PathVariable String name) throws Exception {
		return service.query(name);
	}
	
	/**
	 * 发送同名数据到数据库
	 * 并做排重检测，错误检测
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@Intent("发送%s")
	@RequestMapping("Post")
	public Object post(@RequestBody SnSameName model) throws Exception {
		int insert = service.post(model);
		countService.countQuery(model);
		if (insert == 0) {//没有 添加成功
			errorService.error(model);
		}
		return null;
	}
//	/**
//	 * 添加信息
//	 * 首先调用查询统计 
//	 * 否则把新的数据添加到 SnSameNameErrorService 中
//	 * @param model
//	 * @return
//	 * @throws Exception 
//	 */
//	@Override
//	@RequestMapping("Add")
//	public Object add(@RequestBody SnSameName model) throws Exception {
//		// TODO Auto-generated method stub
//		int insert = service.insert(model);
//		countService.countQuery(model);
//		if (insert == 0) {//没有 添加成功
//			errorService.error(model);
//		}
//		return null;
//	}

//	/**
//	 * 更新信息
//	 * @param model
//	 * @return
//	 * @throws Exception 
//	 */
//	@Override
//	@RequestMapping("Update")
//	public Object update(@RequestBody SnSameName model) throws Exception {
//		// TODO Auto-generated method stub
//		return super.update(model);
//	}

	/**
	 * 根据ID获取信息
	 * @param ID
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("Get/{ID}")
	public Object getByID(@PathVariable String ID) throws Exception {
		// TODO Auto-generated method stub
		return super.getByID(ID);
	}

	/**
	 * 根据ID删除
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("Delete/{ID}")
	public Object delete(String ID) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(ID);
	}

	/**
	 * 统计全部
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("CountAll")
	public Object countAll() throws Exception {
		// TODO Auto-generated method stub
		return super.countAll();
	}

	/**
	 * 获取全部列表
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("GetList")
	public Object getList() throws Exception {
		// TODO Auto-generated method stub
		return super.getList();
	}

	/**
	 * 获取分页列表
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("GetList/{pageSize}/{pageNo}")
	public Object getListByPage(@PathVariable int pageSize,@PathVariable int pageNo) throws Exception {
		// TODO Auto-generated method stub
		return super.getListByPage(pageSize, pageNo);
	}

}
