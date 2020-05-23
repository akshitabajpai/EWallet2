package com.capgemini.EWallet.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;


@Entity
@Table(name="customersupport")

@DynamicUpdate(true)
@DynamicInsert(true)

public class CustomerSupport {
	
	@NotNull(message="ID can not be null")
	@Id
	@Column(name="cust_user_id")
	private Integer customeruserId;
	
	
	@NotEmpty(message="User Name is Mandatory")
	@Size(min=3,max=25,message="Length can be betwwen 3 and 25 chars")
	@Column(name="cust_user_name" ,length=25)
	private String customeruserName;
	

	@NotEmpty(message="Phone no can not be empty")
	@Pattern(regexp="(^$|[0-9]{10})")
	@Column(name="cust_phone_number")
	private String customerphoneNumber;
	
	@NotEmpty(message="Issue can not be empty")
	@Size(min=3,max=1000,message="Issue can be explained  betwwen 3 and 1000 chars")
	@Column(name="cust_issue")
	private String  customerIssue;
	
	@NotNull
	@Column(name="dateof_issue" )
	@JsonDeserialize(using=DateDeserializer .class)
	private Date dateofIssue;

	public CustomerSupport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerSupport(@NotNull(message = "ID can not be null") Integer customeruserId,
			@NotEmpty(message = "User Name is Mandatory") @Size(min = 3, max = 25, message = "Length can be betwwen 3 and 25 chars") String customeruserName,
			@NotEmpty(message = "Phone no can not be empty") @Pattern(regexp = "(^$|[0-9]{10})") String customerphoneNumber,
			@NotEmpty(message = "Issue can not be empty") @Size(min = 3, max = 1000, message = "Issue can be explained  betwwen 3 and 1000 chars") String customerIssue,
			@NotNull Date dateofIssue) {
		super();
		this.customeruserId = customeruserId;
		this.customeruserName = customeruserName;
		this.customerphoneNumber = customerphoneNumber;
		this.customerIssue = customerIssue;
		this.dateofIssue = dateofIssue;
	}

	public Integer getCustomeruserId() {
		return customeruserId;
	}

	public void setCustomeruserId(Integer customeruserId) {
		this.customeruserId = customeruserId;
	}

	public String getCustomeruserName() {
		return customeruserName;
	}

	public void setCustomeruserName(String customeruserName) {
		this.customeruserName = customeruserName;
	}

	public String getCustomerphoneNumber() {
		return customerphoneNumber;
	}

	public void setCustomerphoneNumber(String customerphoneNumber) {
		this.customerphoneNumber = customerphoneNumber;
	}

	public String getCustomerIssue() {
		return customerIssue;
	}

	public void setCustomerIssue(String customerIssue) {
		this.customerIssue = customerIssue;
	}

	public Date getDateofIssue() {
		return dateofIssue;
	}

	public void setDateofIssue(Date dateofIssue) {
		this.dateofIssue = dateofIssue;
	}

	@Override
	public String toString() {
		return "CustomerSupport [customeruserId=" + customeruserId + ", customeruserName=" + customeruserName
				+ ", customerphoneNumber=" + customerphoneNumber + ", customerIssue=" + customerIssue + ", dateofIssue="
				+ dateofIssue + "]";
	}

	
}
	
	