package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component /* ("thatSillyCoach") */
//@Scope("prototype")
public class TennisCoach implements Coach {

	// field injection via annotation
	@Autowired
	//@Qualifier("happyFortuneService")
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// for Spring constructor annotation injection
	/*
	 * @Autowired public TennisCoach(FortuneService theFortuneService) {
	 * fortuneService = theFortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Message from get Daily Workout of tennis Coach";
	}

	public TennisCoach() {
		System.out.println(">>inside default constructor tennis coach");
	}
	
	//define init method
	@PostConstruct
	public void doMystartupStuff() {
		System.out.println("TennisCoach: Do my startup stuff");
	}
	
	//define destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("TennisCoach: Do my Cleanup Stuff");
	}

	// for spring setter injection via annotation
	/*
	 * @Autowired public void setFortuneService(FortuneService theFortuneService) {
	 * System.out.println(">>TennisCoach:inside set fortune service method");
	 * this.fortuneService = theFortuneService; }
	 */
	/// method injection via annotation
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService theFortuneService) {
	 * System.out.println(">>TennisCoach:inside do some crazy stuff method");
	 * this.fortuneService = theFortuneService; }
	 */
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}


}
