package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
/**
 * 数据库表sn_query_count
 * @author 树朾
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
	
	private String sameNameId;
	/**
	 * 数据库列count
	 */
	
	private Integer count;
	/**
	 * 创建时间
	 */
	
	private java.util.Date createTime;

	public SnQueryCount() {
		// TODO Auto-generated constructor stub
	}
	
	public String getKeyId(){
		return this.keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
		
	public String getSameNameId(){
		return this.sameNameId;
	}

	public void setSameNameId(String sameNameId) {
		this.sameNameId = sameNameId;
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
		

}