package com.datastatistics.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.dao.DsFeedbackDao;
import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsFeedback;
import com.datastatistics.service.DsFeedbackService;

/**
 * 数据库表ds_feedback的Service接实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Service
public class DsFeedbackServiceImpl extends BaseServiceImpl<DsFeedback> implements DsFeedbackService{

	@Autowired
	DsFeedbackDao dao;

	@Override
	public void feedback(DsFeedback model, DsApplication application)
			throws Exception {
		// TODO Auto-generated method stub
		DsFeedback byId = dao.findById(model.getKeyId());
		if (byId == null) {
			dao.insert(model);
		}
	}
	
}
