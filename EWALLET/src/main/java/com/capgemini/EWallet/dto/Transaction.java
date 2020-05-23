package com.capgemini.EWallet.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Transaction {
	
	@NotNull(message="Sendr Account ID is mandatory")
	private Integer senderAccountId;
	
	@NotNull(message="Receiver Account ID is mandatory")
	private Integer receiverAccountId;
	
	@NotNull(message="Amount is mandatory")
	@Min(value=1000, message="Can transfer minimum Rs. 1000")
	@Max(value=50000, message="Can transfer maximum Rs. 50000")
	private Double amt;

	public Integer getSenderAccountId() {
		return senderAccountId;
	}

	public void setSenderAccountId(Integer senderAccountId) {
		this.senderAccountId = senderAccountId;
	}

	public Integer getReceiverAccountId() {
		return  receiverAccountId;
	}

	public void setReceiverAccountId(Integer toAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

	public Double getAmt() {
		return amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}	

}
