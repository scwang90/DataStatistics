package com.datastatistics.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sql方法申明，在DaoImpl使用
 * @author 树朾
 * @date 2015-06-09 02:10:51 中国标准时间 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Sql {
	public String value();
}
