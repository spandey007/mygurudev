package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LuvAopExpressions {

	// this is where we add all of our related advice(s) and logging

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create a pointcut to match geeter methode
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {
	}

	// create a pintcut to match setter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	// create a pointcut to include package and exclude getter and setter
	@Pointcut("forDaoPackage() && ! (getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}

}
