package com.datastatistics.dao.impl;

import org.springframework.stereotype.Repository;

import com.datastatistics.dao.DsDeviceDao;
import com.datastatistics.dao.base.BaseDaoImpl;
import com.datastatistics.model.DsDevice;

/**
 * 数据库表ds_device的Dao实现
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Repository
public class DsDeviceDaoImpl extends BaseDaoImpl<DsDevice> implements DsDeviceDao{

	@Override
	public DsDevice findByUniqueId(String uniqueId) throws Exception {
		// TODO Auto-generated method stub
		for (DsDevice device : findByPropertyName("uniqueId", uniqueId)) {
			return device;
		};
		return null;
	}

}

