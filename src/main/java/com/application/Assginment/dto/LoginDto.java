package com.application.Assginment.dto;

public class LoginDto {

	String userName;
	String password;
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDto(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDto [userName=" + userName + ", password=" + password + "]";
	}
	
	public LoginDto() {
		// TODO Auto-generated constructor stub
	}
}
