package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
import com.datastatistics.annotations.dbmodel.Column;
/**
 * 数据库表sn_same_name_error
 * @author 树朾
 * @date 2015-06-09 01:44:14 中国标准时间 
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
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 第三方
	 */\u000A@Column("ss_sss")\u000A
	private java.util.Date ssSss;

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
		
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
		
	public java.util.Date getSsSss(){
		return this.ssSss;
	}

	public void setSsSss(java.util.Date ssSss) {
		this.ssSss = ssSss;
	}
		

}