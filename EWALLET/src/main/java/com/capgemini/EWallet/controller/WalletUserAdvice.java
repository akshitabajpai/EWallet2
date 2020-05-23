package com.capgemini.EWallet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.EWallet.dto.ErrorInfo;
import com.capgemini.EWallet.exception.AccountException;


@RestControllerAdvice
public class WalletUserAdvice {
	@ExceptionHandler(value = {AccountException.class})

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	
	public ErrorInfo handleException1(Exception ex) {
		return new ErrorInfo(ex.getMessage());
	}
}
