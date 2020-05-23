package com.capgemini.EWallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.EWallet.entity.WalletAccount;

public interface AccountDao extends JpaRepository<WalletAccount, Integer>{
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Account a SET a.balance= :balance WHERE a.accId= :accountId")
	int updateBalance(@Param("balance") double balance, @Param("accountId") int accountId);
	
}
