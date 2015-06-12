package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
/**
 * 数据库表sn_same_name_error
 * @author 树朾
 * @date 2015-06-12 17:21:15 中国标准时间 
 */
@Table("sn_same_name_error")
public class SnSameNameError{

	// Fields
	@Id
	/**
	 * 主键ID
	 */
	private String keyId;
	/**
	 * 统计名称
	 */
	private String sameName;
	/**
	 * 各个省份的数量统计，逗号隔开的，int
	 */
	private String countProvince;
	/**
	 * 全国统计总数
	 */
	private Integer countCountry;
	/**
	 * 错误统计次数
	 */
	private Integer count;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 最后更新时间
	 */
	private java.util.Date updateTime;

	public SnSameNameError() {
		// TODO Auto-generated constructor stub
	}
	
	public String getKeyId(){
		return this.keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
		
	public String getSameName(){
		return this.sameName;
	}

	public void setSameName(String sameName) {
		this.sameName = sameName;
	}
		
	public String getCountProvince(){
		return this.countProvince;
	}

	public void setCountProvince(String countProvince) {
		this.countProvince = countProvince;
	}
		
	public Integer getCountCountry(){
		return this.countCountry;
	}

	public void setCountCountry(Integer countCountry) {
		this.countCountry = countCountry;
	}
		
	public Integer getCount(){
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
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