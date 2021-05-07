package com.hubfintech.api.exception;

import java.util.Date;

public class ErrorDetail {
	private Date timeStamp;
	private String message;
	
	public ErrorDetail(Date timeStamp, String message) {
		this.setTimeStamp(timeStamp);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}	
	
}
