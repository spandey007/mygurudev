package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advice(s) and logging

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	//@Before("execution(public void add*())")
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n\n\n=====>>> Executing @Before methode of Aspect on method");
	}

	@Before("forDaoPackage()")
	public void performanceAnalytics() {
		System.out.println("=====>>> Performing API Analytics\n");
	}
}
