package com.app.entities;

public enum ServiceType 
{
	NAIL_SERVICES(2000), 
	SKIN_CARE(1500), 
	HAIR_TREATMENTS(3000), 
	HAIR_SERVICES(2200), 
	SPA_SERVICES(5000), 
	MAKEUP(5500), 
	GROOMING(1000);
	
	private double amount;

	ServiceType(double amount) 
	{
		this.amount = amount;
	}

	//getter & setter
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	//toString
	public String toString()
	{
		return name()+" : " + amount;
	}
}
