package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
	
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println("Random Fortune: "+theCoach.getDailyFortune());

		context.close();
	 
	}

}
