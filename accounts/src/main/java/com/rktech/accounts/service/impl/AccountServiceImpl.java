package com.rktech.accounts.service.impl;

import org.springframework.stereotype.Service;

import com.rktech.accounts.dto.CustomerDto;
import com.rktech.accounts.repository.AccountRepository;
import com.rktech.accounts.repository.CustomerRepository;
import com.rktech.accounts.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService{

	private AccountRepository accountsRepository;
	private CustomerRepository customerRepoitory;
	
	@Override
	public void createAccount(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		
	}

}
