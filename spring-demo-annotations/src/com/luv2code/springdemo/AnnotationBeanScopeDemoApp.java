package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container

		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		//Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

		///boolean result = theCoach == alphaCoach;

		//System.out.println("Pointing to the same object:  " + result);
		// close context

		//System.out.println("Memory Location of theCoach: " + theCoach);
		//System.out.println("Memory Location of alphaCoach: " + alphaCoach);

		context.close();

	}

}
