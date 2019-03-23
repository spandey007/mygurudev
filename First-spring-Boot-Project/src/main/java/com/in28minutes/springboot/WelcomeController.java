package com.in28minutes.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@Autowired
	private WelcomeService welcomeService;
	
	@RequestMapping("/Welcome")
	public String welcomeMessage() {
	return	welcomeService.welcomeMessageService();
	}

	
}


@Component
class WelcomeService{
	
	public String welcomeMessageService() {
		return "In Service Message Method";
	}
}
