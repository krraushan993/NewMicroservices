package com.rktech.accounts.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name="customer_id")
	private Long customerId;
	
	private String name;
	
	private String email;
	
	@Column(name="mobile_Number")
	private String mobileNumber;
}
