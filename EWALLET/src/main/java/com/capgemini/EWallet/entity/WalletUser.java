package com.capgemini.EWallet.entity;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@Table(name = "walletuser")
@DynamicUpdate(true)
@DynamicInsert(true)
public class WalletUser {
	
	@NotNull(message="User Id is Mandatory")
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="user_seq")
	@SequenceGenerator(sequenceName="user_seq",initialValue=1000,allocationSize=1,name="user_seq")
	private int userId;
	
	@NotNull(message="UserName is Mandatory")
	@Size(min=3,max=25,message="Length must be from 3 to 25 character ")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message="allow only alphabets and a blank space is allowed" )
	@Column(name="user_name",length=25)
	private String userName;
	
	@NotEmpty(message = "user password is mandatory")
	@Column(name="user_password")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,14}$",message="Password must have Number and one uppercase letter and special characters")
	private String password;
	
	@NotNull(message="Phone number is Mandatory")
	@Size(max=10,message="Number must be of 10 digits")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phoneNumber;
	
	@NotNull(message="Login Name is Mandatory")
	@Size(min=3,max=25,message="Length can be betwwen 3 and 25 chars")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message="allow only alphabets and a blank scpace is allowed" )
	@Column(name="login_name" ,length=25)
	private String loginName;

	
	
	public WalletUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public WalletUser(int userId,String userName,String password, String phoneNumber, String loginName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.loginName = loginName;
	}

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}




	@Override
	public String toString() {
		return "WalletUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", loginName=" + loginName + ", ]";
	}
	



	
	
	
	

}