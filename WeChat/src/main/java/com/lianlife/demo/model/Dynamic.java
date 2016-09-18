package com.lianlife.demo.model;

import java.util.Date;
import java.util.List;

public class Dynamic {
	private String userId;
	private Date createTime;
	private String userName;
	private String userImage;
	private String messageId;
	private String messageContent;
	private byte[] msgContentBlob;
	private List<Comment> commentList;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
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
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public byte[] getMsgContentBlob() {
		return msgContentBlob;
	}
	public void setMsgContentBlob(byte[] msgContentBlob) {
		this.msgContentBlob = msgContentBlob;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

}
