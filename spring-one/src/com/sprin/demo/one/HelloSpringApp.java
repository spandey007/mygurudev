package com.sprin.demo.one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach theCoach = context.getBean("myCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

	/*	System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("<-------------- Some bullshit ------------------->");
		System.out.println();
		System.out.println();
		System.out.println();

		Coach theCriCoach = context.getBean("myCricketCoach", Coach.class);
		System.out.println(theCriCoach.getDailyWorkout());
		System.out.println(theCriCoach.getDailyFortune());*/
		context.close();
	}

}
