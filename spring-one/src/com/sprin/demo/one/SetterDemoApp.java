package com.sprin.demo.one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("before getBean");
		CricketCoach crickCoach = context.getBean("myCricketCoach", CricketCoach.class);
		System.out.println(crickCoach.getDailyWorkout());

		System.out.println(crickCoach.getDailyFortune());

		System.out.println(crickCoach.getEmailAddress());
		System.out.println(crickCoach.getTeam());

		context.close();
	}

}
