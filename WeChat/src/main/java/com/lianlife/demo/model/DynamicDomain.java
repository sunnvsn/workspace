package com.lianlife.demo.model;

import java.util.Date;

public class DynamicDomain extends BaseDomain{
	private String userName;
	private String userImage;
	private String messageId;
	private String userId;
	private byte[] messageContent;
	private Date createTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public byte[] getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(byte[] messageContent) {
		this.messageContent = messageContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
