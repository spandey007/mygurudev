package com.sprin.demo.one;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) 
	{fortuneService = theFortuneService;}

	@Override
	public String getDailyWorkout() {
		return "get daily workout of BaseBall Coach";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
