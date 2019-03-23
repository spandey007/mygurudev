package com.luv2code.aopdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from container

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		//callthe method to find the Accounts
		List<Account> theAccounts = theAccountDAO.findAccount(false);
		
		//display the accounts
		System.out.println("\n\nMain program: AfterReturningDemoApp");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
		

		context.close();

	}

}
