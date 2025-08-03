package com.rktech.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Accounts extends BaseEntity{

	@Column(name="customer_id")
	private Long customer_id;
	
	@Column(name="account_number")
	@Id
	private Long ccountNumber;
	
	@Column(name="account_type")
	private String accountType;
	
    @Column(name="branch_address")
	private String branchAddress;
}
