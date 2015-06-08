package com.simple.toadiot.rtinfosdk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Description: 所有顶层Model的基类
 * @Author: scwang
 * @Version: V1.0, 2015-3-5 下午9:04:15
 */
public abstract class DomainObject {

	@JsonIgnore
	public abstract String getId();

	@JsonIgnore
	public abstract void setId(String id);
}
