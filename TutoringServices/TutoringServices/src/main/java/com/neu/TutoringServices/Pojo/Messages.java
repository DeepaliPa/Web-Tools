package com.neu.TutoringServices.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Messages")
public class Messages {

	@Id
	@GeneratedValue
	@Column(name = "messageId", unique=true, nullable = false)
    private long messageId;
	
	@Column(name="userName")
    private String userName;
	
	@Column(name="fromUser")
    private String fromUser;
	
	@Column(name="message")
    private String message;

	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

    
    
}
