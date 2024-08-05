package com.application.Assginment.dto.responce;

public class UserInfoDto {

	String massages;
	int statusCode;
	Long userId;
	public String getMassages() {
		return massages;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setMassages(String massages) {
		this.massages = massages;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public UserInfoDto()
	{
		
	}
		
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public UserInfoDto(String massages, int statusCode, Long userId) {
		super();
		this.massages = massages;
		this.statusCode = statusCode;
		this.userId = userId;
	}
	public UserInfoDto(String massages, int statusCode) {
		super();
		this.massages = massages;
		this.statusCode = statusCode;
		
	}
	@Override
	public String toString() {
		return "UserLoginDto [massages=" + massages + ", statusCode=" + statusCode + ", userId=" + userId + "]";
	}
	

}
