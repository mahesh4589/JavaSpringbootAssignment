package com.application.Assginment.dto;

public class UserDto {

	
	Long id;	
	String  firstName;
	String lastName;
	String phNo;
	String emailId;
	String password;
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhNo() {
		return phNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDto(String password) {
		super();
		this.password = password;
	}
	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phNo=" + phNo
				+ ", emailId=" + emailId + ", password=" + password + "]";
	}
	public UserDto()
	{
		
	}
	public UserDto(Long id, String firstName, String lastName, String phNo, String emailId, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phNo = phNo;
		this.emailId = emailId;
		this.password = password;
	}
}
