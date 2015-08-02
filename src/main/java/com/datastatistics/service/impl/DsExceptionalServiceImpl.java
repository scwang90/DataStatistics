package com.datastatistics.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.dao.DsExceptionalDao;
import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsExceptional;
import com.datastatistics.service.DsExceptionalService;

/**
 * 数据库表ds_exceptional的Service接实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Service
public class DsExceptionalServiceImpl extends BaseServiceImpl<DsExceptional> implements DsExceptionalService{

	@Autowired
	DsExceptionalDao dao;

	@Override
	public void exceptional(DsExceptional model,DsApplication application) throws Exception {
		// TODO Auto-generated method stub
		DsExceptional byId = dao.findById(model.getKeyId());
		if (byId == null) {
			dao.insert(model);
		}
	}
	
}
