package com.datastatistics.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.dao.DsDeviceDao;
import com.datastatistics.dao.DsEventDao;
import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsDevice;
import com.datastatistics.model.DsEvent;
import com.datastatistics.service.DsEventService;
import com.datastatistics.util.AfStringUtil;
import com.datastatistics.util.ServiceException;

/**
 * 数据库表ds_event的Service接实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Service
public class DsEventServiceImpl extends BaseServiceImpl<DsEvent> implements DsEventService{

	@Autowired
	DsEventDao dao;
	
	@Autowired
	DsDeviceDao deviceDao;
	
	@Override
	public void triggerEvent(DsEvent model, DsApplication application) throws Exception {
		// TODO Auto-generated method stub
		DsDevice device = deviceDao.findByUniqueId(model.getUniqueId());
		if (device == null) {
			throw new ServiceException("无效设备ID");
		}
		DsEvent byId = dao.findById(model.getKeyId());
		if (byId == null) {
			for (DsEvent event : dao.findByUniqueIdHour(model.getUniqueId())) {
				if (AfStringUtil.equals(model.getEventId(), event.getEventId())
						&& AfStringUtil.equals(model.getParameter(), event.getParameter())
						&& AfStringUtil.equals(model.getRemark(), event.getRemark())) {
					if (event.getCount() != null) {
						event.setCount(1+event.getCount());
					} else {
						event.setCount(2);
					}
					dao.update(event);
					return;
				}
			}
			dao.insert(model);
		}
	}
}
