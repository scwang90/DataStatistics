package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
/**
 * 数据库表ds_device_initiate
 * @author 树朾
 * @date 2015-07-29 22:55:48 中国标准时间
 */
@Table("ds_device_initiate")
public class DsDeviceInitiate{

	// Fields
	@Id
	/**
	 * ID主键
	 */
	private String keyId;
	/**
	 * 启动类型（start，close）
	 */
	private String type;
	/**
	 * 设备唯一ID
	 */
	private String uniqueId;
	/**
	 * 应用ID
	 */
	private String appId;
	/**
	 * 渠道
	 */
	private String channel;
	/**
	 * 是否新用户
	 */
	private Boolean isNew;
	/**
	 * 用户相关ID
	 */
	private String userId;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;

	public DsDeviceInitiate() {
		// TODO Auto-generated constructor stub
	}
	
	public String getKeyId(){
		return this.keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
		
	public String getType(){
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
		
	public String getUniqueId(){
		return this.uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
		
	public String getAppId(){
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public Boolean getIsNew() {
		return isNew;
	}
	
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
		
	public String getUserId(){
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
		
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
		
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public static DsDeviceInitiate from(DsDevice model) {
		// TODO Auto-generated method stub
		DsDeviceInitiate initiate = new DsDeviceInitiate();
		initiate.setAppId(model.getAppId());
		initiate.setUniqueId(model.getUniqueId());
		initiate.setUserId(model.getUserId());
		return initiate;
	}
		

}