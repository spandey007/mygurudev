package com.sprin.demo.one;

public class CricketCoach implements Coach {
	private String emailAddress;
	private String team;
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String email) {
		System.out.println("CricketCoach inside Setter method : - setEmailAddress");
		this.emailAddress = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach inside Setter method : - setTeam");
		this.team = team;
	}

	private FortuneService fortuneService;

	public CricketCoach() {
		System.out.println( "default constructor for cricket coach");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Get daily workout of Cricket Coach";
	}

	public void setFortuneService(FortuneService theFortuneService) {

		System.out.println("CricketCoach inside Setter method : - setFortuneService");
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyFortune() {

		return "Ja be bhai " + fortuneService.getFortune();
	}

}
