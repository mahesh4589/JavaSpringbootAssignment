package com.application.Assginment.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "CustomerTransaction")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Trans_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    private User customer;
    @Column(name = "spentDetails")
    private String spentDetails;
    @Column(name = "amount")
    private double amount;
    @Column(name = "date")
    private LocalDate date;
    public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public User getCustomer() {
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
	public void setCustomer(User customer) {
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
	public Transaction(Long id, User customer, String spentDetails, double amount, LocalDate date) {
		super();
		this.id = id;
		this.customer = customer;
		this.spentDetails = spentDetails;
		this.amount = amount;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", customer=" + customer + ", spentDetails=" + spentDetails + ", amount="
				+ amount + ", date=" + date + "]";
	}


}
