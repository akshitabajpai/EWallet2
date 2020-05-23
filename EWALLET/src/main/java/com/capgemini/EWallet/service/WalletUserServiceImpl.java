package com.capgemini.EWallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.EWallet.dao.WalletUserDao;
import com.capgemini.EWallet.dto.Login;
import com.capgemini.EWallet.entity.WalletUser;
import com.capgemini.EWallet.exception.AccountException;


@Service
public  class WalletUserServiceImpl  implements WalletUserService {
	
	@Autowired
	private WalletUserDao walletuserdao;

	@Override
	public List<WalletUser> getAllWalletUser() {
		// TODO Auto-generated method stub
		return walletuserdao.findAll();
	}
	
	@Override
	public WalletUser saveUser(WalletUser user) {
		return walletuserdao.save(user);
	}

	@Override
	public boolean addUser(WalletUser walletuser) {
	
		WalletUser accountResult= walletuserdao.save(walletuser);
		if(accountResult!=null) {
			return true;
		}
		else
			return false;
	}
	@Override
	public WalletUser validateUser(Login userLogin) throws AccountException{
		
		Optional<WalletUser> optionalUser= walletuserdao.LoginDetails(userLogin.getUserName());
		WalletUser user;
		if(optionalUser.isPresent()) {
			user=optionalUser.get();
			if(user.getPassword().equals(userLogin.getPassword())){
				return user;
			}
			throw new AccountException("Incorrect Password");
			
		}
		else
			throw new AccountException("Incorrect User Name");
			
		

	}
	

	
	
	
}

