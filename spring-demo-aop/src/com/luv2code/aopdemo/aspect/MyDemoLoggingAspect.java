package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices and logging

	//@Before("execution(public void add*())")
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n\n\n=====>>> Executing @Before methode of Aspect on method");
	}

}
