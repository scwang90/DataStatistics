package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
/**
 * 数据库表ds_event
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Table("ds_event")
public class DsEvent{

	// Fields
	@Id
	/**
	 * ID主键
	 */
	private String keyId;
	/**
	 * 事件ID
	 */
	private String eventId;
	/**
	 * 设备唯一ID
	 */
	private String uniqueId;
	/**
	 * 应用ID
	 */
	private String appId;
	/**
	 * 事件参数
	 */
	private String parameter;
	/**
	 * 次数统计
	 */
	private Integer count;
	/**
	 * 渠道
	 */
	private String channel;
	/**
	 * 备注
	 */
	private String remark;
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

	public DsEvent() {
		// TODO Auto-generated constructor stub
		this.count = 1;
	}
	
	public String getKeyId(){
		return this.keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
		
	public String getEventId(){
		return this.eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
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
		
	public String getParameter(){
		return this.parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	public Integer getCount() {
		return count;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public void setChannel(String channel) {
		this.channel = channel;
	}
		
	public String getRemark(){
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		

}