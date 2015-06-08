/*
 * Copyright (C) 2013 www.418log.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datastatistics.annotations.dbmodel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface Table.
 * 表示表
 * @author 树朾
 * @date 2015-06-09 01:44:14 中国标准时间 
 */
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	/**
	 * 表名.
	 *
	 * @return the string
	 */
	public String value() default "";
}
