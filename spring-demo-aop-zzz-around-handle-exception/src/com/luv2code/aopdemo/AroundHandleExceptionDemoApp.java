package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from container

		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\n Main Program : AroundDemoApp");

		myLogger.info("Calling getFortune");

		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);

		myLogger.info("\n My Fortune is: " + data);
		
		myLogger.info("\nFinished");
		
		//close the context
		
		context.close();

	}

}
