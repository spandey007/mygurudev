package com.sell.snm;

import java.util.Random;

public class SnMRandomThoughtsService implements RandomThoughtsService {
	private String[] rArray =new String[3];

	public String[] thArray = new String[] { "Being sexy is all about attitude, not body type. It's a state of mind.",
			"A lot of people would say 'sexy' is about the body. But to me, 'sexy' is a woman with confidence. I admire women who have very little fear",
			"I'm not trying to be sexy. It's just my way of expressing myself when I move around.",
			"A woman can be sexy, charming, witty or shy with her shoes.",
			"There's something about a humid, dusky evening that's kind of sexy.",
			"I know it sounds weird, but my definition of 'sexy' has changed as I've gotten older. And being smart and informed makes me feel sexier than any outfit.",
			"I know it sounds weird, but my definition of 'sexy' has changed as I've gotten older. And being smart and informed makes me feel sexier than any outfit.",
			"Chunao ladenge chaude se haare jeete laude se" };
	
	private Random rand = new Random();

	@Override
	public String[] getRandomThought() {
		
		rArray[0]= thArray[rand.nextInt(thArray.length)];
		rArray[1]= thArray[rand.nextInt(thArray.length)];
		rArray[2]= thArray[rand.nextInt(thArray.length)];
		
		return rArray ;
	}

}
