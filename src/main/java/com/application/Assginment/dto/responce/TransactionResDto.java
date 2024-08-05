package com.application.Assginment.dto.responce;

public class TransactionResDto {

	String massages;
	int statusCode;
	
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
	public TransactionResDto()
	{
		
	}
		public void setUserId(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public TransactionResDto(String massages, int statusCode ) {
		super();
		this.massages = massages;
		this.statusCode = statusCode;
	}
		
	@Override
	public String toString() {
		return "UserLoginDto [massages=" + massages + ", statusCode=" + statusCode +  "]";
	}
	

}
