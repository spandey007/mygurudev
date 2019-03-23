package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + " : Doing my DB Work: Adding an Account: addAccount() :");
	}

	public boolean doWork() {
		System.out.println(getClass() + " : Doing my Work: doWork() :");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + " : In getName():");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " : In setName():");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : In getServiceCode():");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : In Set ServiceCode():");
		this.serviceCode = serviceCode;
	}
	
}
