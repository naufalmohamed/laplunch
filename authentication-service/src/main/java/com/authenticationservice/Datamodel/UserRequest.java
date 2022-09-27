package com.authenticationservice.Datamodel;

import java.io.Serializable;

public class UserRequest  implements Serializable{
	
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8091879091924046844L;
	private String email;
	private String password;
	
	
	
	public UserRequest() {
		
	}
	public UserRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
