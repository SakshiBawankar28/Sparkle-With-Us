package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="review")
public class Review extends BaseEntity{
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id ;
	
	@Column(length = 20 , name = "first_name", nullable = false)
	private String firstName;
	
	@Column(length = 20 , name = "last_name", nullable = false)
	private String lastName;
	
	@Column(length = 100 )
	private String comments;
	
	@Min(1)
    @Max(5)
	private int rating;

	
	@OneToOne
	@JoinColumn(name = "customer_id",nullable= false)
	private  Customer customer;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(String firstName, String lastName, String comments, int rating, Customer customer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.comments = comments;
		this.rating = rating;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Review [firstName=" + firstName + ", lastName=" + lastName + ", comments=" + comments + ", rating="
				+ rating + ", customer=" + customer + "]";
	}
	
}
