package com.luv2code.springdemo;

public class KabbadiCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public KabbadiCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Daily Workout of KabbadiCoach";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
