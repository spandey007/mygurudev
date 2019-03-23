package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out the method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>>>@Around (Finally) on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// now let's execute the method
		Object result = null;

		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning("Exception caught: " + e.getMessage());
			/*
			 * //give user a custom message result = "Major Accident! But no Worries, "+
			 * "your private AOP helicopter is on the way";
			 */
			throw e;
		}

		// get end timestamp

		long end = System.currentTimeMillis();

		// compute duration and display
		long duration = end - begin;
		myLogger.info("====>>>Duration: " + duration / 1000.0 + " Seconds");

		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterfinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>>>@After (Finally) on method: " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>>>@AfterThrowing on method: " + method);

		// log exception
		myLogger.info("\n===>>> The Exception is : " + theExc);

	}

	// add a new advice @AfterReturning on findAccount() method

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>>>@AfterReturning on method: " + method);
		// print out the result of method call

		myLogger.info("\n====>>>>Result is: " + result);

		// let's post-process the data and modify it

		// Convert the account names to upper case

		convertAccountNamesToUpperCase(result);
		myLogger.info("\n====>>>>Result is: " + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts

		for (Account tempAccount : result) {

			// get upper case version of the names

			String theUpperName = tempAccount.getName().toUpperCase();

			// update the name on the account object
			tempAccount.setName(theUpperName);
		}
	}

	// @Before("execution(public void add*())")
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n\n\n=====>>> Executing @Before methode of Aspect on method");

		// display the method signature

		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("Method: " + methodSig);

		// display method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop thru args
		for (Object tempArg : args) {
			myLogger.info("Method Arguments :" + tempArg.toString());
			if (tempArg instanceof Account) {

				// downcast and print Account specific stuff

				Account theAccount = (Account) tempArg;

				myLogger.info("account name:" + theAccount.getName());
				myLogger.info("account name:" + theAccount.getLevel());
			}
		}

	}
}
