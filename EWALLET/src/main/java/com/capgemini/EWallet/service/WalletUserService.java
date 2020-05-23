package com.capgemini.EWallet.service;

import java.util.List;

import com.capgemini.EWallet.dto.Login;
import com.capgemini.EWallet.entity.WalletUser;



public interface WalletUserService {
	
	boolean addUser(WalletUser walletuser);
	List<WalletUser> getAllWalletUser();
	
	WalletUser saveUser(WalletUser user);
	WalletUser validateUser(Login userLogin);

}
