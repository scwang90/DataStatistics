package com.datastatistics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastatistics.dao.SnProvinceDao;
import com.datastatistics.dao.SnSameNameDao;
import com.datastatistics.dao.base.MultiDao;
import com.datastatistics.model.SnProvince;
import com.datastatistics.model.SnSameName;
import com.datastatistics.model.entity.CountProvinceEntity;
import com.datastatistics.model.entity.SameName;
import com.datastatistics.service.SnSameNameService;
import com.datastatistics.util.JacksonUtil;
import com.datastatistics.util.ServiceException;

/**
 * 数据库表sn_same_name的Service接实现
 * @author 树朾
 * @date 2015-06-09 02:10:52 中国标准时间     
 */
@Service
public class SnSameNameServiceImpl extends BaseServiceImpl<SnSameName> implements SnSameNameService{

	@Autowired
	SnSameNameDao dao;

	@Autowired
	SnProvinceDao provinceDao;
	
	@Autowired
	MultiDao<SnSameName> snSameNameDaoImpl;

	/**
	 * 添加 同名数据的时候先检测使用已经存在同名数据
	 * 如果存在，取出老数据，比对结果如果一样返回1代表成功，不一样0代表失败，
	 * 如果不存在 直接添加数据 
	 */
	@Override
	public int post(SnSameName model) throws Exception {
		// TODO Auto-generated method stub
		Class<CountProvinceEntity> clazz = CountProvinceEntity.class;
		List<CountProvinceEntity> entities = JacksonUtil.toObjects(model.getCountProvince(), clazz);
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).getPoepleCount() <= 0) {
				entities.remove(i--);
			}
		}
		model.setCountProvince(JacksonUtil.toJson(entities));
		List<SnSameName> list = snSameNameDaoImpl.findByPropertyName("sameName", model.getSameName());
		for (SnSameName sameName : list) {
			return sameName.getCountProvince().equals(model.getCountProvince())?1:0;
		}
		return super.insert(model);
	}

	@Override
	public List<SameName> query(String name) throws Exception {
		// TODO Auto-generated method stub
		List<SameName> names = new ArrayList<SameName>();
		List<SnProvince> provinces = provinceDao.findAll();
		for (SnSameName snSameName : snSameNameDaoImpl.findByPropertyName("sameName", name)) {
			Class<CountProvinceEntity> clazz = CountProvinceEntity.class;
			List<CountProvinceEntity> objects = JacksonUtil.toObjects(snSameName.getCountProvince(), clazz);
			for (SnProvince snProvince : provinces) {
				for (CountProvinceEntity entity : objects) {
					if (entity.getProvinceCode() == snProvince.getCode()
							&& entity.getPoepleCount() > 0) {
						SameName sameName = new SameName();
						sameName.code = snProvince.getCode();
						sameName.name = snProvince.getName();
						sameName.people =  entity.getPoepleCount();
						names.add(sameName);
					}
				}	
			}
			break;
		}
		return names;
	}

	@Override
	public int insert(SnSameName model) throws Exception {
		// TODO Auto-generated method stub
		throw new ServiceException("添加 方法被关闭");
		//return super.insert(model);
	}

	@Override
	public int update(SnSameName model) throws Exception {
		// TODO Auto-generated method stub
		throw new ServiceException("更新 方法被关闭");
		//return super.update(model);
	}

	
}
