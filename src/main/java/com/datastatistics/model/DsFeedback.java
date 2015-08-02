package com.datastatistics.model;


import com.datastatistics.annotations.dbmodel.Id;
import com.datastatistics.annotations.dbmodel.Table;
/**
 * 数据库表ds_feedback
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
@Table("ds_feedback")
public class DsFeedback{

	// Fields
	@Id
	/**
	 * ID主键
	 */
	private String keyId;
	/**
	 * 回复ID
	 */
	private String replyId;
	/**
	 * 是否官方回复
	 */
	private Boolean isReply;
	/**
	 * 应用ID
	 */
	private String appId;
	/**
	 * 反馈标题
	 */
	private String title;
	/**
	 * 反馈内容
	 */
	private String content;
	/**
	 * 联系方式
	 */
	private String contact;
	/**
	 * 渠道
	 */
	private String channel;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;
	/**
	 * 用户相关信息（建议用JSON，max-256）
	 */
	private String user;
	/**
	 * 应用版本信息
	 */
	private String version;
	/**
	 * 错误信息
	 */
	private String bug;

	public DsFeedback() {
		// TODO Auto-generated constructor stub
	}
	
	public String getKeyId(){
		return this.keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
		
	public String getReplyId(){
		return this.replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
		
	public Boolean getIsReply(){
		return this.isReply;
	}

	public void setIsReply(Boolean isReply) {
		this.isReply = isReply;
	}
		
	public String getAppId(){
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
		
	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
		
	public String getContent(){
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
		
	public String getContact(){
		return this.contact;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public void setChannel(String channel) {
		this.channel = channel;
	}

	public void setContact(String contact) {
		this.contact = contact;
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
		
	public String getUser(){
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}
		
	public String getVersion(){
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
		
	public String getBug(){
		return this.bug;
	}

	public void setBug(String bug) {
		this.bug = bug;
	}
		

}