
package com.edu.pos5ible.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Administrator
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String password;
	private String userNick;
	private String phoneNum;
	private String address;
	private char gender;
	private String qq;
	private String email;
	private Date birthday;
	private Integer authority;
	private String token;
	private Timestamp updateDate;
	private Timestamp createDate;
	private Integer userStatus;
	
	public User(){
		
	}

	public User(Integer userId, String password, String userNick, String phoneNum, String address, char gender,
			String qq, String email, Date birthday, Integer authority, String token, Timestamp updateDate,
			Timestamp createDate, Integer userStatus) {
		super();
		this.userId = userId;
		this.password = password;
		this.userNick = userNick;
		this.phoneNum = phoneNum;
		this.address = address;
		this.gender = gender;
		this.qq = qq;
		this.email = email;
		this.birthday = birthday;
		this.authority = authority;
		this.token = token;
		this.updateDate = updateDate;
		this.createDate = createDate;
		this.setUserStatus(userStatus);
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", userNick=" + userNick + ", phoneNum=" + phoneNum
				+ ", address=" + address + ", gender=" + gender + ", qq=" + qq + ", email=" + email + ", birthday="
				+ birthday + ", authority=" + authority + ", token=" + token + ", updateDate=" + updateDate
				+ ", createDate=" + createDate + ", userStatus=" + userStatus + "]";
	}
}
