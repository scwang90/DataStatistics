package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
/**
 * 数据库表ds_application
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Table("ds_application")
public class DsApplication{

	// Fields
	@Id
	/**
	 * ID主键
	 */
	private String keyId;
	/**
	 * 应用名称
	 */
	private String name;
	/**
	 * 应用类型（Android,IOS,Windows）
	 */
	private String type;
	/**
	 * 应用描述
	 */
	private String description;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;

	public DsApplication() {
		// TODO Auto-generated constructor stub
	}
	
	public String getKeyId(){
		return this.keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
		
	public String getName(){
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public String getType(){
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
		
	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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