package com.capgemini.EWallet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.EWallet.dto.TransferBean;
import com.capgemini.EWallet.entity.WalletAccount;
import com.capgemini.EWallet.exception.AccountException;
import com.capgemini.EWallet.service.AccountService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TransferController {

	@Autowired
	private AccountService ser;
	
	//@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/viewallaccount")
	public ResponseEntity<List<WalletAccount>> getAccount(){
		List<WalletAccount> accountList= ser.viewAccount();
		return new ResponseEntity<List<WalletAccount>>(accountList,HttpStatus.OK);
	}
	
	//@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addaccount")
	public ResponseEntity<String> addAccount(@Valid @RequestBody WalletAccount account, BindingResult br) throws AccountException
	{
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors= br.getFieldErrors();
			for(FieldError error:errors)
				err +=error.getDefaultMessage() +"<br/>";
			throw new AccountException(err);
		}
		try {
			ser.addAccount(account);
			return new ResponseEntity<String>("Account added", HttpStatus.OK);
			
		}
		catch(DataIntegrityViolationException ex) {
			throw new AccountException("Account ID already exists");
		}
	}
	
	//@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/transfer")
	public ResponseEntity<String> transferFund(@Valid @RequestBody TransferBean tbean, BindingResult br) throws AccountException
	{
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors =br.getFieldErrors();
			for(FieldError error:errors)
				err+=error.getDefaultMessage()+"<br/>";
			throw new AccountException(err);
		}
		ser.transferFund(tbean.getFromAccountId(), tbean.getToAccountId(), tbean.getAmt());
		return new ResponseEntity<String>("Amount Transferred", HttpStatus.OK);
	}

	
}
