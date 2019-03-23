package com.sprin.demo.one;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach() {
	}

	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Get daily workout track coach";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	// add init method

	public void doMyStartupStuff() {
		System.out.println("TrackCoach: Do my startup stuff");
	}

		public void doMyCleanupStuffyoyo() {
			System.out.println("TrackCoach: Do doMyCleanupStuffyoyo");
		
	}

	// add destroy method

}
