package com.datastatistics.dao.base;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.UUID;

import com.datastatistics.annotations.dbmodel.interpreter.Interpreter;
import com.datastatistics.util.AfReflecter;
/**
 * 通用Dao实现基类
 * @param <T>
 * @author 树朾
 * @date 2015-06-09 02:10:52 中国标准时间 
 */
public class BaseDaoImpl<T> extends BaseDaoDbUtilMYSQLImpl<T> implements BaseDao<T>{

	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
		order = "ORDER BY createTime DESC";
	}
	
	@Override
	public int insert(T t) throws Exception {
		// TODO Auto-generated method stub
		checkNullID(t);
		AfReflecter.setMemberNoException(t, "createTime", new Date());
		AfReflecter.setMemberNoException(t, "updateTime", new Date());
		return super.insert(t);
	}
	
	@Override
	public int update(T t) throws Exception {
		// TODO Auto-generated method stub
		AfReflecter.setMemberNoException(t, "updateTime", new Date());
		return super.update(t);
	}
	
	@Override
	public int update(T t, Object id) throws Exception {
		// TODO Auto-generated method stub
		AfReflecter.setMemberNoException(t, "updateTime", new Date());
		return super.update(t, id);
	}

	/**
	 * 检查ID字段是否为空，否则设置一个新ID
	 * @param model
	 * @throws Exception
	 */
	protected void checkNullID(T model) throws Exception {
		Class<?> clazz = model.getClass();
		Field field = Interpreter.getIdField(clazz);
		field.setAccessible(true);
		Object id = field.get(model);
		if(id == null || id.toString().trim().length() == 0){
			field.set(model, UUID.randomUUID().toString());
		}
	}
}
