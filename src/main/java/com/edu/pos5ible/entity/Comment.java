package com.edu.pos5ible.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer commentId;
	private Integer id;
	private Integer commentUserId;
	private String commentContent;
	private Timestamp commentDate;
	private Integer likeNum;
	private Integer unlikeNum;
	
	public Comment() {
		
	}

	public Comment(Integer commentId, Integer id, Integer commentUserId, String commentContent, Timestamp commentDate,
			Integer likeNum, Integer unlikeNum) {
		super();
		this.commentId = commentId;
		this.id = id;
		this.commentUserId = commentUserId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.likeNum = likeNum;
		this.unlikeNum = unlikeNum;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(Integer commentUserId) {
		this.commentUserId = commentUserId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public Integer getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}

	public Integer getUnlikeNum() {
		return unlikeNum;
	}

	public void setUnlikeNum(Integer unlikeNum) {
		this.unlikeNum = unlikeNum;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", id=" + id + ", commentUserId=" + commentUserId
				+ ", commentContent=" + commentContent + ", commentDate=" + commentDate + ", likeNum=" + likeNum
				+ ", unlikeNum=" + unlikeNum + "]";
	}


}
