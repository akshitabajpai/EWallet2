package com.capgemini.EWallet.service;

import java.util.List;

import com.capgemini.EWallet.entity.CustomerSupport;



public interface CustomerSupportService {
	
	boolean addIssue(CustomerSupport customersupport);
	List<CustomerSupport> getAllIssue();
	
	CustomerSupport saveIssue(CustomerSupport customersupport);

}
	