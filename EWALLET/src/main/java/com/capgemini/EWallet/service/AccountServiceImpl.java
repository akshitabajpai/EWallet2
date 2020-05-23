package com.capgemini.EWallet.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.EWallet.dao.AccountDao;
import com.capgemini.EWallet.entity.WalletAccount;
import com.capgemini.EWallet.exception.AccountException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public boolean addAccount(WalletAccount account) {
		WalletAccount accountResult= accountDao.save(account);
		if(accountResult!=null) {
			return true;
		}
		else
			return false;
	}
	
	@Override
	public boolean transferFund(int from, int to, double amt) throws AccountException
	{
		WalletAccount fromAccount, toAccount;
		Optional<WalletAccount> fromAccountOptional=accountDao.findById(from);
		if(fromAccountOptional.isPresent()) {
			fromAccount=fromAccountOptional.get();
		}
		else {
			throw new AccountException("From Account ID is not present");
		}
		
		Optional<WalletAccount> toAccountOptional=accountDao.findById(to);
		if(toAccountOptional.isPresent()) {
			toAccount=toAccountOptional.get();
		}
		else {
			throw new AccountException("To Account ID is not present");
		}
		
		if(fromAccount.getBalance()<amt) throw new AccountException("Insufficient Balance");
		fromAccount.setBalance(fromAccount.getBalance()-amt);
		toAccount.setBalance(toAccount.getBalance()+amt);
		accountDao.updateBalance(fromAccount.getBalance(), fromAccount.getAccId());
		accountDao.updateBalance(toAccount.getBalance(), toAccount.getAccId());
		return true;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<WalletAccount> viewAccount(){
		return accountDao.findAll();
	}
	

}
