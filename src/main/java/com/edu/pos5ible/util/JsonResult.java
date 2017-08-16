package com.edu.pos5ible.util;

import java.io.Serializable;

import com.edu.pos5ible.exception.userException.AddressException;
import com.edu.pos5ible.exception.userException.BirthdayException;
import com.edu.pos5ible.exception.userException.EmailException;
import com.edu.pos5ible.exception.userException.GenderException;
import com.edu.pos5ible.exception.userException.NameException;
import com.edu.pos5ible.exception.userException.OldPasswordException;
import com.edu.pos5ible.exception.userException.PasswordException;
import com.edu.pos5ible.exception.userException.QqException;
import com.edu.pos5ible.exception.userException.UserException;
import com.edu.pos5ible.exception.userException.UserIdException;

/**
 * 用于封装AJAX调用以后的JSON返回值
 * 其中正确返回值:
 *  {state:0, data:返回数据, message:错误消息}
 * 错误返回值:
 *  {state:1, data:null, message:错误消息}
 */


public class JsonResult implements Serializable{
	private static final long serialVersionUID = -3644950655568598241L;

	public static final Integer SUCCESS=0;
	public static final Integer ERROR=1;
	public static final Integer USEREXCEPTION=2;
	public static final Integer ADDRESSEXCEPTION=3;
	public static final Integer BIRTHDAYEXCEPTION=4;
	public static final Integer EMAILEXCEPTION=5;
	public static final Integer GENDEREXCEPTION=6;
	public static final Integer NAMEEXCEPTION=7;
	public static final Integer OLDPASSWORDEXCEPTION=8;
	public static final Integer PASSWORDEXCEPTION=9;
	public static final Integer QQEXCEPTION=10;
	public static final Integer USERIDEXCEPTION=11;
	
	/** 
	 * 返回是否成功的状态, 0表示成功, 
	 * 1或其他值 表示失败
	 */
	private int state;
	/**
	 * 成功时候,返回的JSON数据
	 */
	private Object data;
	/**
	 * 是错误时候的错误消息
	 */
	private String message;
	
	
	public JsonResult() {
		
	}


	public JsonResult(int state, Object data, String message) {
 		this.state = state;
		this.data = data;
		this.message = message;
	}
	
	public JsonResult(Throwable e){
		state = ERROR;
		data=null;
		message=e.getMessage();
	}

	public JsonResult(UserException e){
		state = USEREXCEPTION;
		data=null;
		message=e.getMessage();
	}
	
	public JsonResult(AddressException e){
		state = ADDRESSEXCEPTION;
		data=null;
		message=e.getMessage();
	}
	
	public JsonResult(BirthdayException e){
		state = BIRTHDAYEXCEPTION;
		data=null;
		message=e.getMessage();
	}
	
	public JsonResult(EmailException e){
		state = EMAILEXCEPTION;
		data=null;
		message=e.getMessage();
	}
	
	public JsonResult(GenderException e){
		state = GENDEREXCEPTION;
		data=null;
		message=e.getMessage();
	}
	
	public JsonResult(NameException e){
		state = NAMEEXCEPTION;
		data=null;
		message=e.getMessage();
	}
	
	public JsonResult(OldPasswordException e){
		state = OLDPASSWORDEXCEPTION;
		data=null;
		message=e.getMessage();
	}
	
	public JsonResult(PasswordException e){
		state = PASSWORDEXCEPTION;
		data=null;
		message=e.getMessage();
	}
	
	public JsonResult(QqException e){
		state = QQEXCEPTION;
		data=null;
		message=e.getMessage();
	}
	
	public JsonResult(UserIdException e){
		state = USERIDEXCEPTION;
		data=null;
		message=e.getMessage();
	}
	
	public JsonResult(Object data){
		state = SUCCESS;
		this.data=data;
		message="";
	}

	public JsonResult(int state, Throwable e) {
		this.state = state;
		data=null;
		message = e.getMessage();
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", data=" + data + ", message=" + message + "]";
	}
}







