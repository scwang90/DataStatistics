package com.datastatistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datastatistics.annotations.Intent;
import com.datastatistics.controller.base.GeneralController;
import com.datastatistics.model.SnProvince;

/**
 * 数据库表sn_province 的Controller层实现
 * @author 树朾
 */
@Intent("SnProvince")
@Controller
@RequestMapping("SnProvince")
public class SnProvinceController extends GeneralController<SnProvince>{

	/**
	 * 添加信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@Override
	@ResponseBody
	@RequestMapping("add")
	public Object add(SnProvince model) throws Exception {
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
	@ResponseBody
	@RequestMapping("update")
	public Object update(SnProvince model) throws Exception {
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
	@ResponseBody
	@RequestMapping("getByID")
	public Object getByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		return super.getByID(ID);
	}

	/**
	 * 根据ID删除
	 * @return
	 * @throws Exception 
	 */
	@Override
	@ResponseBody
	@RequestMapping("delete")
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
	@ResponseBody
	@RequestMapping("countAll")
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
	@ResponseBody
	@RequestMapping("getAll")
	public Object getAll() throws Exception {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	/**
	 * 获取分页列表
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws Exception 
	 */
	@Override
	@ResponseBody
	@RequestMapping("getListByPage")
	public Object getListByPage(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		return super.getListByPage(pageSize, pageNo);
	}


}
