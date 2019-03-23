package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// @Before("execution(public void add*())")
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n\n\n=====>>> Executing @Before methode of Aspect on method");
	}

	// shifted to other class for sharing
	/*
	 * // this is where we add all of our related advice(s) and logging
	 * 
	 * @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))") private void
	 * forDaoPackage() { }
	 * 
	 * // create a pointcut to match geeter methode
	 * 
	 * @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))") private void
	 * getter() { }
	 * 
	 * // create a pintcut to match setter method
	 * 
	 * @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))") private void
	 * setter() { }
	 * 
	 * // create a pointcut to include package and exclude getter and setter
	 * 
	 * @Pointcut("forDaoPackage() && ! (getter() || setter())") private void
	 * forDaoPackageNoGetterSetter() { }
	 */

	// moved for ordering
	/*
	 * @Before("forDaoPackageNoGetterSetter()") public void performanceAnalytics() {
	 * System.out.println("=====>>> Performing API Analytics"); }
	 */

	/*
	 * @Before("forDaoPackageNoGetterSetter()") public void logToCloudAsync() {
	 * System.out.println("=====>>> Logging to cloud in async fashion\n"); }
	 */
}
