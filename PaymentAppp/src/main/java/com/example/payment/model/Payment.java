package com.example.payment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String bank;
    private String transactionId;
    private double amount;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getBank() {
		return bank;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
