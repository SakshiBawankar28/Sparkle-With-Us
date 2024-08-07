package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment extends BaseEntity
{
	@OneToOne
	@JoinColumn(name = "customer_id",nullable= false)
	private  Customer customer;

	private double amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name="payment_mode",length = 30)
	private PaymentMode paymentMode;
	
	//ctor
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	//para-ctor
	public Payment(Customer customer, double amount, PaymentMode paymentMode) {
		super();
		this.customer = customer;
		this.amount = amount;
		this.paymentMode = paymentMode;
	}

	//getter & setter
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	//toString
	@Override
	public String toString() {
		return "Payment [customer=" + customer + ", amount=" + amount + ", paymentMode=" + paymentMode + "]";
	}
	
	
}
