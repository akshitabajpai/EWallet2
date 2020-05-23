package com.capgemini.EWallet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@Table(name="cg_account")
@DynamicUpdate(true)
@DynamicInsert(true)
public class WalletAccount {
	
	@NotNull(message="Account ID Is Mandatory")
	@Id
	@Column(name="acc_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acc_seq")
	@SequenceGenerator(sequenceName = "acc_seq", initialValue = 04010100 , allocationSize = 1, name = "acc_seq")
	private Integer accId;
	
	@NotEmpty(message=" Name Is Mandatory")
	@Size(min=3, max=25, message="Length can be 3 and 25 chars")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message="allow only alphabets and a blank space is allowed" )
	@Column(name="cust_name", length=25)
	private String name;
	
	@NotNull(message="Balance Is Mandatory")
	@Min(value=1000, message="Your Opening amount must be Rs.1000")
	private Double balance;

	public WalletAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WalletAccount(Integer accId, String name, Double balance) {
		super();
		this.accId = accId;
		this.name = name;
		this.balance = balance;
	}

	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return accId + " "+   name + " "+ balance ;
	}
	
}
