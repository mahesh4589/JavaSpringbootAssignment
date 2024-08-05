package com.application.Assginment.model;


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
@Table(name = "RewardPoints")
public class RewardPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reward_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    private User customer;
    @Column(name = "month")
    private int month;
    @Column(name = "year")
    private int year;
    @Column(name = "points")
    private int points;
	public Long getId() {
		return id;
	}
	public RewardPoints() {
		// TODO Auto-generated constructor stub
	}
	public User getCustomer() {
		return customer;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public int getPoints() {
		return points;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public RewardPoints(Long id, User customer, int month, int year, int points) {
		super();
		this.id = id;
		this.customer = customer;
		this.month = month;
		this.year = year;
		this.points = points;
	}
	@Override
	public String toString() {
		return "RewardPoints [id=" + id + ", customer=" + customer + ", month=" + month + ", year=" + year + ", points="
				+ points + "]";
	}

    // Getters and Setters
}
