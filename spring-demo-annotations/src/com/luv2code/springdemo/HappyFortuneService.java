package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	
	@Value("${fort}")
	private String[] fortunes;

	private Random rand = new Random();
	
	@PostConstruct
	public void readFortune() {
	System.out.println("HappyFortuneService:PostConstruct fortune "+fortunes[rand.nextInt(fortunes.length)]);	
	}

	@Override
	public String getFortune() {

		Integer index = rand.nextInt(fortunes.length);
		String fortune = fortunes[index];
		return fortune;
		// return "This is your lucky day";
	}
	
	@PreDestroy
	public void destroyMethod() {
		System.out.println("HappyFortuneService:Inside predestroy annotations destroyMethod");
	}
	

}
