/*This mapper class mapping DTO to entity and entity to DTO to save some time.*/

package com.rktech.accounts.mapper;

import com.rktech.accounts.dto.AccountsDto;
import com.rktech.accounts.entity.Accounts;

public class AccountsMapper {

	/**
	 * @param accounts
	 * @param accountsDto
	 * @return
	 * It is map all the data from Accounts to AccountsDto with the help of the Setters and Getters methods.
	 * Simple logic it will copy all the account number,account type and branch address to the DTO to the
	 * method where is trying to invoke this method which is mapToAccountDto and this is static method.
	 */
	public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {

		accountsDto.setAccountNumber(accounts.getAccountNumber());
		accountsDto.setAccountType(accounts.getAccountType());
		accountsDto.setBranchAddress(accounts.getBranchAddress());
		return accountsDto;
	}
	
	public static Accounts mapToAccounts(AccountsDto accountsDto,Accounts accounts) {
		
		accounts.setAccountNumber(accountsDto.getAccountNumber());
		accounts.setAccountType(accountsDto.getAccountType());
		accounts.setBranchAddress(accountsDto.getBranchAddress());
		return accounts;
	}

}
