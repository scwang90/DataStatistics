package com.datastatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datastatistics.controller.base.GeneralController;
import com.datastatistics.model.SnSameName;
import com.datastatistics.service.SnSameNameService;

/**
 * 数据库表sn_same_name 的Controller层实现
 * @author 树朾
 */
@Controller
@RequestMapping("SnSameName")
public class SnSameNameController extends GeneralController<SnSameName>{

	@Autowired 
	SnSameNameService service;
	
	/**
	 * 客户端查询结果提交
	 * @param name 查询名称
	 * @param value 查询结果
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="submit"/*,consumes="application/json;charset=UTF-8"*/)
	public SnSameName submit(/*@RequestBody */final String sameName){
		return new SnSameName();
		//		return new Execute() {public Object execute() throws Exception {
//			service.insert(JacksonUtil.toObject(sameName, SnSameName.class));
//			return null;
//		}}.exe("提交%s");
	}
	/**
	 * 添加信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@Override
	@ResponseBody
	@RequestMapping("add")
	public Object add(SnSameName model) throws Exception {
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
	public Object update(SnSameName model) throws Exception {
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
