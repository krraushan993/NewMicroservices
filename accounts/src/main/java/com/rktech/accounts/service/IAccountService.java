package com.rktech.accounts.service;

import com.rktech.accounts.dto.CustomerDto;

public interface IAccountService {

	/**
	 * @param customerDto - CustomerDto Object
	 */
	void createAccount(CustomerDto customerDto);

	/**
	 * @param Input mobileNumber
	 * @return AccountsDetails based on a given mobileNumber
	 */
	CustomerDto fetchAccount(String mobileNumber);
	
	/**
	 * @param customerDto-CustomerDto object
	 * @return boolean indicating if the update of account details is successful or not
	 */
	boolean updateAccount(CustomerDto customerDto);
	
}
