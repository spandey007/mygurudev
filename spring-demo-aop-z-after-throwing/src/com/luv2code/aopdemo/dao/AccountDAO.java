package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	// add a new method: findAccounts()

	public List<Account> findAccount(boolean tripWire) {

		// for acadamic purpose
		if (tripWire) {
			throw new RuntimeException("No Soup For You!!!");
		}

		List<Account> myAccount = new ArrayList<>();

		// create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luka", "Gold");

		// add to the list

		myAccount.add(temp1);
		myAccount.add(temp2);
		myAccount.add(temp3);

		return myAccount;
	}

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
