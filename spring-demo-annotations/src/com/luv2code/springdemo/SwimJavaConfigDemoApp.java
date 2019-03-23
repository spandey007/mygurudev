package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		AnnotationConfigApplicationContext logContext = new AnnotationConfigApplicationContext(MyLoggerConfig.class);
		
		// Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println("Fortune: " + theCoach.getDailyFortune());

		// swim coach defined methods
		System.out.println("Email: " + theCoach.getEmail());
		System.out.println("Team: " + theCoach.getTeam());

		context.close();
		logContext.close();

	}

}
