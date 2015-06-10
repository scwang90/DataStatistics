package com.datastatistics.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastatistics.annotations.Intent;
import com.datastatistics.controller.base.GeneralController;
import com.datastatistics.model.SnSameNameError;

/**
 * 数据库表sn_same_name_error 的Controller层实现
 * @author 树朾
 * @date 2015-06-09 02:10:51 中国标准时间     
 */
@RestController
@Intent("数据库表sn_same_name_error")
@RequestMapping("SnSameNameError")
public class SnSameNameErrorController extends GeneralController<SnSameNameError>{


	/**
	 * 添加信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@Override
	//@RequestMapping("Add")
	public Object add(@RequestBody SnSameNameError model) throws Exception {
		// TODO Auto-generated method stub
		return super.add(model);
	}

	/**
	 * 更新信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@Override
	//@RequestMapping("Update")
	public Object update(@RequestBody SnSameNameError model) throws Exception {
		// TODO Auto-generated method stub
		return super.update(model);
	}

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
