package com.rktech.accounts.service;

import com.rktech.accounts.dto.CustomerDto;



public interface IAccountService {

	/**
	 * @param customerDto - CustomerDto Object
	 */
	void createAccount(CustomerDto customerDto);
}
