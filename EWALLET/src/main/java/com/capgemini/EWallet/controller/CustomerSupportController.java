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

import com.capgemini.EWallet.entity.CustomerSupport;
import com.capgemini.EWallet.exception.AccountException;
import com.capgemini.EWallet.service.CustomerSupportService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CustomerSupportController {

	@Autowired
	private CustomerSupportService ser;
	
	@GetMapping("/viewallissue")
	public ResponseEntity<List<CustomerSupport>> getAllissue(){
		List<CustomerSupport> issueList= ser.getAllIssue();
		return new ResponseEntity<List<CustomerSupport>>(issueList,HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addissue")
	public ResponseEntity<String> addIssue(@Valid @RequestBody CustomerSupport customersupport, BindingResult br) throws AccountException
	{
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors= br.getFieldErrors();
			for(FieldError error:errors)
				err +=error.getDefaultMessage() +"<br/>";
			throw new AccountException(err);
		}
		try {
			ser.addIssue(customersupport);
			return new ResponseEntity<String>("New Issue added", HttpStatus.OK);
			
		}
		catch(DataIntegrityViolationException ex) {
			throw new AccountException("Same issue for same user already exists");
		}
	}
	
	

}
