package com.example.Product_Service.model;

public class Product {
	private String name;
	private int maxLoanAmount;
	private int minAge;
	private int maxAge;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMaxLoanAmount() {
		return maxLoanAmount;
	}
	
	public void setMaxLoanAmount(int maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
	
	public int getMinAge() {
		return minAge;
	}
	
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	
	public int getMaxAge() {
		return maxAge;
	}
	
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
}
