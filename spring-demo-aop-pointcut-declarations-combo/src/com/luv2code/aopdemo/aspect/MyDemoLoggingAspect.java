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
	private void forDaoPackage() {
	}

	// create a pointcut to match geeter methode
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// create a pintcut to match setter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// create a pointcut to include package and exclude getter and setter
	@Pointcut("forDaoPackage() && ! (getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}

	// @Before("execution(public void add*())")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n\n\n=====>>> Executing @Before methode of Aspect on method");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performanceAnalytics() {
		System.out.println("=====>>> Performing API Analytics\n");
	}
}
