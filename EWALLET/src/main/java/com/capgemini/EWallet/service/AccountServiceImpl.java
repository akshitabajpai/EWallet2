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
	public boolean transferFund(int sender, int receiver, double amt) throws AccountException
	{
		WalletAccount senderAccount, receiverAccount;
		Optional<WalletAccount> senderAccountOptional=accountDao.findById(sender);
		if(senderAccountOptional.isPresent()) {
			senderAccount=senderAccountOptional.get();
		}
		else {
			throw new AccountException("sender Account ID is not present");
		}
		
		Optional<WalletAccount> receiverAccountOptional=accountDao.findById(receiver);
		if(receiverAccountOptional.isPresent()) {
			receiverAccount=receiverAccountOptional.get();
		}
		else {
			throw new AccountException("Receiver Account ID is not present");
		}
		
		if(senderAccount.getBalance()<amt) throw new AccountException("Insufficient Balance");
		senderAccount.setBalance(senderAccount.getBalance()-amt);
		receiverAccount.setBalance(receiverAccount.getBalance()+amt);
		accountDao.updateBalance(senderAccount.getBalance(), senderAccount.getAccId());
		accountDao.updateBalance(receiverAccount.getBalance(), receiverAccount.getAccId());
		return true;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<WalletAccount> viewAccount(){
		return accountDao.findAll();
	}
	

}
