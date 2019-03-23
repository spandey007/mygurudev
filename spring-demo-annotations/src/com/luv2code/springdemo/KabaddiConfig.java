package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KabaddiConfig {
	
	@Bean
	public FortuneService kabaddiFortuneService() {
		return new KabaddiFortuneService();
	}

	@Bean
	public Coach kabaddiCoach(FortuneService theFortuneService) {
		return new KabbadiCoach(kabaddiFortuneService());
		
	}
}
