package com.luv2code.aopdemo.aspect;

import java.util.List;

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

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out the method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>>>@Around (Finally) on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// now let's execute the method
		Object result = theProceedingJoinPoint.proceed();

		// get end timestamp

		long end = System.currentTimeMillis();

		// compute duration and display
		long duration = end - begin;
		System.out.println("====>>>Duration: " + duration / 1000.0 + " Seconds");

		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterfinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>>>@After (Finally) on method: " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>>>@AfterThrowing on method: " + method);

		// log exception
		System.out.println("\n===>>> The Exception is : " + theExc);

	}

	// add a new advice @AfterReturning on findAccount() method

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>>>@AfterReturning on method: " + method);
		// print out the result of method call

		System.out.println("\n====>>>>Result is: " + result);

		// let's post-process the data and modify it

		// Convert the account names to upper case

		convertAccountNamesToUpperCase(result);
		System.out.println("\n====>>>>Result is: " + result);

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
		System.out.println("\n\n\n=====>>> Executing @Before methode of Aspect on method");

		// display the method signature

		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("Method: " + methodSig);

		// display method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop thru args
		for (Object tempArg : args) {
			System.out.println("Method Arguments :" + tempArg);
			if (tempArg instanceof Account) {

				// downcast and print Account specific stuff

				Account theAccount = (Account) tempArg;

				System.out.println("account name:" + theAccount.getName());
				System.out.println("account name:" + theAccount.getLevel());
			}
		}

	}
}
