package com.capgemini.EWallet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.EWallet.dao.AccountDao;
import com.capgemini.EWallet.entity.WalletAccount;


@SpringBootApplication
public class SpringBootRestfullWebServicesBankApp1Application  {

	 @Autowired
		private AccountDao accountDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestfullWebServicesBankApp1Application.class, args);
		
	}
	
	
	  

}
