package com.application.Assginment.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	Long id;
	@Column(name = "firstName")
	String firstName;
	@Column(name = "lastName")
	String lastName;
	@Column(name = "phNo")
	String phNo;
	@Column(name = "emailId")
	String emailId;
	@Column(name = "password")
	String password;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<RewardPoints> rewardPoints;
    
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
	public String getPassword() {
		return password;
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
	public void setPassword(String password) {
		password = password;
	}
	public User(Long id, String firstName, String lastName, String phNo, String emailId, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phNo = phNo;
		this.emailId = emailId;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phNo=" + phNo
				+ ", emailId=" + emailId + ", Password=" + password + "]";
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
}
