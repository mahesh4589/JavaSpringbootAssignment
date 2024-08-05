package com.application.Assginment.dto;

import java.time.LocalDate;

import com.application.Assginment.model.User;


public class TransactionDto {
	
	
	    private Long id;	   
	    private UserDto customer;	   
	    private String spentDetails;	  
	    private double amount;	
	    private LocalDate date;
		public Long getId() {
			return id;
		}
		public UserDto getCustomer() {
			return customer;
		}
		public String getSpentDetails() {
			return spentDetails;
		}
		public double getAmount() {
			return amount;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setCustomer(UserDto customer) {
			this.customer = customer;
		}
		public void setSpentDetails(String spentDetails) {
			this.spentDetails = spentDetails;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public TransactionDto(Long id, UserDto customer, String spentDetails, double amount, LocalDate date) {
			super();
			this.id = id;
			this.customer = customer;
			this.spentDetails = spentDetails;
			this.amount = amount;
			this.date = date;
		}
		@Override
		public String toString() {
			return "TransactionDto [id=" + id + ", customer=" + customer + ", spentDetails=" + spentDetails
					+ ", amount=" + amount + ", date=" + date + "]";
		}

		public TransactionDto() {
			// TODO Auto-generated constructor stub
		}
}
