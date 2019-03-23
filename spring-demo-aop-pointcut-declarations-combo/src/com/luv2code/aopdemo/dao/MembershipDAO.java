package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyMember() {

		System.out.println(getClass() + ": Doing some DB work: Adding a Silly membership account");
		return false;
	}

	public void goToSleep() {
		System.out.println(getClass() + ": Going to Sleep Now:");
	}

}
