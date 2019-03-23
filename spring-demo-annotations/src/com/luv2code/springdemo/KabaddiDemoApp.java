package com.luv2code.springdemo;

import java.lang.reflect.AnnotatedArrayType;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KabaddiDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KabaddiConfig.class);
		
		 KabbadiCoach theCoach = context.getBean("kabaddiCoach",KabbadiCoach.class);
		 System.out.println(theCoach.getDailyWorkout());
		 System.out.println(theCoach.getDailyFortune());
		 
		 
		 context.close();
		 
		

	}

}
