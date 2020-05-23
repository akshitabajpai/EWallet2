package com.capgemini.EWallet.service;

import java.util.List;

import com.capgemini.EWallet.entity.WalletAccount;
import com.capgemini.EWallet.exception.AccountException;

public interface AccountService {
	boolean addAccount(WalletAccount account);
	boolean transferFund(int sender, int receiver, double amt) throws AccountException;
	List<WalletAccount> viewAccount();
}
