package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
/**
 * 数据库表sn_query_count
 * @author 树朾
 * @date 2015-06-12 17:21:15 中国标准时间 
 */
@Table("sn_query_count")
public class SnQueryCount{

	// Fields
	@Id
	/**
	 * 主键ID
	 */
	private String keyId;
	/**
	 * 姓名外键
	 */
	private String sameName;
	/**
	 * 查询次数统计
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

	public SnQueryCount() {
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