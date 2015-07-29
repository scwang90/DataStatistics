package com.datastatistics.dao;

import com.datastatistics.dao.base.BaseDao;
import com.datastatistics.model.DsDevice;

/**
 * 数据库表ds_device的Dao接口
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
public interface DsDeviceDao extends BaseDao<DsDevice>{

	/**
	 * 根据UniqueID获取
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DsDevice findByUniqueId(String uniqueId) throws Exception;

}
