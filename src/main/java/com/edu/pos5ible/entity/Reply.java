package com.edu.pos5ible.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reply implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer replyId;
	private Integer commentId;
	private Integer replyUserId;
	private Integer replyedUserId;
	private String replyContent;
	private Timestamp replyDate;
	
	public Reply() {
		
	}

	public Reply(Integer replyId, Integer commentId, Integer replyUserId, Integer replyedUserId, String replyContent,
			Timestamp replyDate) {
		super();
		this.replyId = replyId;
		this.commentId = commentId;
		this.replyUserId = replyUserId;
		this.replyedUserId = replyedUserId;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(Integer replyUserId) {
		this.replyUserId = replyUserId;
	}

	public Integer getReplyedUserId() {
		return replyedUserId;
	}

	public void setReplyedUserId(Integer replyedUserId) {
		this.replyedUserId = replyedUserId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", commentId=" + commentId + ", replyUserId=" + replyUserId
				+ ", replyedUserId=" + replyedUserId + ", replyContent=" + replyContent + ", replyDate=" + replyDate
				+ "]";
	}
}
