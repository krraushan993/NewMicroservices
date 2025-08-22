package com.rktech.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rktech.accounts.constants.AccountsConstants;
import com.rktech.accounts.dto.CustomerDto;
import com.rktech.accounts.dto.ResponseDto;
import com.rktech.accounts.service.IAccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
public class AccountController {

	private final IAccountService iAccountService;
	/* Create accounts */

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {

		iAccountService.createAccount(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
	}

	@GetMapping("/fetch")
	public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam("mobileNumber") String mobileNumber) {
		CustomerDto customerDto = iAccountService.fetchAccount(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerDto);

	}

	@PutMapping("/Update")
	public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto) {
		boolean isUpdated = iAccountService.updateAccount(customerDto);
		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));

		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));

		}

	}

}
