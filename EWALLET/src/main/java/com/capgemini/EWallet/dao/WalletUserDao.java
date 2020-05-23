package com.capgemini.EWallet.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.EWallet.entity.WalletUser;



public interface WalletUserDao extends JpaRepository<WalletUser, Integer>  {

	
	@Query("select d from WalletUser d  where d.userName =:userName")
	Optional<WalletUser> LoginDetails(@Param("userName") String userName);
	


}
  