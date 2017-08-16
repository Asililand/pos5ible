package com.edu.pos5ible.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Content implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer userId;
	private Timestamp createDate;
	private String title;
	private String content;
	private Integer clickNum;
	private Integer likeNum;
	private Integer unlikeNum;
	
	public Content() {
		
	}

	public Content(Integer id, Integer userId, Timestamp createDate, String title, String content, Integer clickNum,
			Integer likeNum, Integer unlikeNum) {
		super();
		this.id = id;
		this.userId = userId;
		this.createDate = createDate;
		this.title = title;
		this.content = content;
		this.clickNum = clickNum;
		this.likeNum = likeNum;
		this.unlikeNum = unlikeNum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", userId=" + userId + ", createDate=" + createDate + ", title=" + title
				+ ", content=" + content + ", clickNum=" + clickNum + ", likeNum=" + likeNum + ", unlikeNum="
				+ unlikeNum + "]";
	}
}
