package com.datastatistics.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.dao.DsDeviceDao;
import com.datastatistics.dao.DsDeviceInitiateDao;
import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsDevice;
import com.datastatistics.model.DsDeviceInitiate;
import com.datastatistics.model.constant.DeviceInitiateType;
import com.datastatistics.service.DsDeviceService;
import com.datastatistics.util.ServiceException;

/**
 * 数据库表ds_device的Service接实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Service
public class DsDeviceServiceImpl extends BaseServiceImpl<DsDevice> implements DsDeviceService{

	@Autowired
	DsDeviceDao dao;

	@Autowired
	DsDeviceInitiateDao deviceInitiateDao;
	
	@Override
	public void initDevice(DsDevice model, DsApplication application,String channel)
			throws Exception {
		// TODO Auto-generated method stub
		DsDevice device = dao.findByUniqueId(model.getUniqueId());
		DsDeviceInitiate initiate = DsDeviceInitiate.from(model);
		initiate.setType(DeviceInitiateType.start.toString());
		initiate.setIsNew(device == null);
		initiate.setChannel(channel);
		if (device == null) {
			dao.insert(model);
		}else {
			dao.update(model);
		}
		deviceInitiateDao.insert(initiate);
	}

	@Override
	public void uninstall(DsDevice model, DsApplication application,String channel)
			throws Exception {
		// TODO Auto-generated method stub
		DsDevice device = dao.findByUniqueId(model.getUniqueId());
		if (device == null) {
			throw new ServiceException("无效设备ID");
		}else {
			dao.update(model);
		}
		DsDeviceInitiate initiate = DsDeviceInitiate.from(model);
		initiate.setType(DeviceInitiateType.close.toString());
		initiate.setIsNew(false);
		initiate.setChannel(channel);
		deviceInitiateDao.insert(initiate);
	}
}
