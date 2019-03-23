package com.luv2code.aopdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from container

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// callthe method to find the Accounts

		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate an exception
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccount(tripWire);
		} catch (Exception exc) {
			System.out.println("\n\n Main Program ... Caught exception: " + exc);
		}

		// display the accounts
		System.out.println("\n\nMain program: AfterThrowingDemoApp");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");

		context.close();

	}

}
