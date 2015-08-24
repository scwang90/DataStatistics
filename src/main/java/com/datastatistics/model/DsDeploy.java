package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
/**
 * 数据库表ds_deploy
 * @author 树朾
 * @date 2015-08-24 11:35:56 中国标准时间
 */
@Table("ds_deploy")
public class DsDeploy{

	// Fields
	@Id
	/**
	 * ID主键
	 */
	private String keyId;
	/**
	 * 应用ID
	 */
	private String appId;
	/**
	 * 配置名称
	 */
	private String name;
	/**
	 * url参数（多个用 | 隔开）
	 */
	private String urls;
	/**
	 * 应用版本
	 */
	private String version;
	/**
	 * 配置备注
	 */
	private String remark;
	/**
	 * 是否开启商业模式
	 */
	private Boolean business;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;

	public DsDeploy() {
		// TODO Auto-generated constructor stub
	}
	
	public String getKeyId(){
		return this.keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
		
	public String getAppId(){
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
		
	public String getName(){
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public String getUrls(){
		return this.urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}
		
	public String getVersion(){
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
		
	public String getRemark(){
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
		
	public Boolean getBusiness(){
		return this.business;
	}

	public void setBusiness(Boolean business) {
		this.business = business;
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