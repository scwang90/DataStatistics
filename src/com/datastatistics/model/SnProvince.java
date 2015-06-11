package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
/**
 * 数据库表sn_province
 * @author 树朾
 * @date 2015-06-11 13:42:12 中国标准时间 
 */
@Table("sn_province")
public class SnProvince{

	// Fields
	@Id
	/**
	 * 主键ID
	 */
	private String keyId;
	/**
	 * 省份的名称
	 */
	private String name;
	/**
	 * 省份所国家统一编号
	 */
	private Short code;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;

	public SnProvince() {
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
		
	public Short getCode(){
		return this.code;
	}

	public void setCode(Short code) {
		this.code = code;
	}
		
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
		

}