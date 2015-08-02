package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
/**
 * 数据库表ds_device
 * @author 树朾
 * @date 2015-08-01 21:07:32 中国标准时间
 */
@Table("ds_device")
public class DsDevice{

	// Fields
	@Id
	/**
	 * ID主键
	 */
	private String keyId;
	/**
	 * 设备唯一ID
	 */
	private String uniqueId;
	/**
	 * 应用ID
	 */
	private String appId;
	/**
	 * 设备imei
	 */
	private String imei;
	/**
	 * 设备mac地址
	 */
	private String mac;
	/**
	 * 用户相关ID
	 */
	private String userId;
	/**
	 * IP地址
	 */
	private String ipAddress;
	/**
	 * 设备型号
	 */
	private String device;
	/**
	 * 设备类型
	 */
	private String type;
	/**
	 * 省会
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;

	public DsDevice() {
		// TODO Auto-generated constructor stub
	}
	
	public String getKeyId(){
		return this.keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
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
		
	public String getImei(){
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
		
	public String getMac(){
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
		
	public String getUserId(){
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
		
	public String getIpAddress(){
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
		
	public String getDevice(){
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
		
	public String getType(){
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
		
	public String getProvince(){
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
		
	public String getCity(){
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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
		
}