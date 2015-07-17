package com.shuim.util;

public class XmlResult {
	private String message;
	private boolean error = false;
	private String name;
	private String phone;
	private String email;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMessage(String message) {
	    this.message = message;
	}
	public String getMessage() {
	    return this.message;
	}

	public void setError(boolean error) {
	    this.error = error;
	}
	public boolean getError() {
	    return this.error;
	}
}
