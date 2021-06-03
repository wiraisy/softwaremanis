package com.softwareseni.wiraisy.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Transaction{

	private Long transaction_id;
	@Autowired
	private Parent parent;
	private String type;
	private Double amount;
		
	public Transaction() {
		
	}

	public Transaction(Long transaction_id, Parent parent, String type, Double amount) {
		this.transaction_id = transaction_id;
		this.parent = parent;
		this.type = type;
		this.amount = amount;
	}

	public Long getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
	

}
