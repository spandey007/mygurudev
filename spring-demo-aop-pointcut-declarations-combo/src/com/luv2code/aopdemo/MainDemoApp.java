package com.luv2code.aopdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from container

		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		// call business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();

		//call AccountDao getters and setters
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name= theAccountDAO.getName();		
		String service = theAccountDAO.getServiceCode();
		
		
		//get membership bean from container
		
		MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
		
		//call add account method of membership method
		
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		
		// close the context
		
		context.close();

	}

}
