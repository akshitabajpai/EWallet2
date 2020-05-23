package com.capgemini.EWallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.EWallet.dao.CustomerSupportDao;
import com.capgemini.EWallet.entity.CustomerSupport;



@Service
public class CustomerSupportServiceImpl implements CustomerSupportService {
	
	
	@Autowired
	private CustomerSupportDao customersupportdao;

	@Override
	public List<CustomerSupport> getAllIssue() {
		// TODO Auto-generated method stub
		return customersupportdao.findAll();
	}
	
	@Override
	public CustomerSupport saveIssue(CustomerSupport customersupport) {
		return customersupportdao.save(customersupport);
	}

	@Override
	public boolean addIssue(CustomerSupport customersupport) {
	
		CustomerSupport supportResult= customersupportdao.save(customersupport);
		if(supportResult!=null) {
			return true;
		}
		else
			return false;
	}
	}
