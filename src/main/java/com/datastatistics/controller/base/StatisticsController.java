package com.datastatistics.controller.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.datastatistics.model.DsApplication;
import com.datastatistics.service.DsApplicationService;
import com.datastatistics.util.ServiceException;

public class StatisticsController<T> extends GeneralController<T> {

	@Autowired
	DsApplicationService serviceApplication;
	
	public DsApplication verifyAppKey(String appId) throws Exception {
		// TODO Auto-generated method stub
		DsApplication application = serviceApplication.findById(appId);
		if (application == null) {
			throw new ServiceException("AppKey无效！");
		}
		return application;
	}

}
