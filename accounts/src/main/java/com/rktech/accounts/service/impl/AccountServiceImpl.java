package com.rktech.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


import org.springframework.stereotype.Service;

import com.rktech.accounts.constants.AccountsConstants;
import com.rktech.accounts.dto.CustomerDto;
import com.rktech.accounts.entity.Accounts;
import com.rktech.accounts.entity.Customer;
import com.rktech.accounts.exception.CustomerAlreadyExistsException;
import com.rktech.accounts.mapper.CustomerMapper;
import com.rktech.accounts.repository.AccountRepository;
import com.rktech.accounts.repository.CustomerRepository;
import com.rktech.accounts.service.IAccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
	
	private AccountRepository accountsRepository;
	private CustomerRepository customerRepository;

	@Override
	public void createAccount(CustomerDto customerDto) {
		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
		if (optionalCustomer.isPresent()) {
			throw new CustomerAlreadyExistsException(
					"Customer already registered with the given mobileNumber" + customerDto.getMobileNumber());
		}
		customer.setCreatedAt(LocalDateTime.now());
		customer.setCreatedBy("Anonymous");
		Customer savedCustomer = customerRepository.save(customer);
		/**
		 * AccountRepository and invoke the save method.To this method,we need to pass
		 * the object of Accounts entity populated with the value like
		 * customerId,acccountNumber all these details.
		 */
		accountsRepository.save(createNewAccount(savedCustomer));

	}

	/**
	 * @param customer - Customer Object
	 * @return the new account details
	 */
	private Accounts createNewAccount(Customer customer) {
		Accounts newAccount = new Accounts();
		newAccount.setCustomerId(customer.getCustomerId());
		long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

		newAccount.setAccountNumber(randomAccNumber);
		newAccount.setAccountType(AccountsConstants.SAVINGS);
		newAccount.setBranchAddress(AccountsConstants.ADDRESS);
		newAccount.setCreatedAt(LocalDateTime.now());
		newAccount.setCreatedBy("Anonymous");
		return newAccount;
	}

}
