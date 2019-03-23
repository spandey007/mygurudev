package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of string
	private String[] data = { "Beware of wolf in sheep's clothes", "Diligence is mother of good luck",
			"The Journey is the reward" };
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		// pick a random fortune on that array
		Integer index = myRandom.nextInt(data.length);
		String fortune = data[index];
		return fortune;
	}

}
