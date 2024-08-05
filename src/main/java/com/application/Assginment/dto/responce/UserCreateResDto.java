package com.application.Assginment.dto.responce;

public class UserCreateResDto {

	private String massages;
	private int statusCode;
	

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

	public UserCreateResDto() {

	}

	

	public UserCreateResDto(String massages, int statusCode) {
		super();
		this.massages = massages;
		this.statusCode = statusCode;

	}

	@Override
	public String toString() {
		return "UserCreateResDto [massages=" + massages + ", statusCode=" + statusCode + "]";
	}

}
