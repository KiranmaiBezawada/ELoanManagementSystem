package com.wellsfargo.elps.model;

public class User {
	
	private String username;
	private String password;
	private int uid;
	public User() {
		
	}
	public String getUsername() {
		return username;
	}
	
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String password ) {
		super();
		this.username = username;
		this.password = password;
		
	}
	

}
