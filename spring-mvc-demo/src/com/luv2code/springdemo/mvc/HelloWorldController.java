package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// Create controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		System.out.println("inside showForm method");
		return "helloworld-form";
	}

	// need a controller method to process the HTML Form
	@RequestMapping("processForm")
	public String processForm() {
		return "helloworld";
	}

	// new controller method to read form data
	// add data to model

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request parameter from the html form
		String theName = request.getParameter("studentName");
		// convert the data all in the upper case

		theName = theName.toUpperCase();
		// create the message

		String result = "Yo!! " + theName;

		// add the message to the model

		model.addAttribute("message", result);

		return "helloworld";
	}

	@RequestMapping("/processFormVersionThree")
	public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {

		/*
		 * //read the request parameter from the html form String theName =
		 * request.getParameter("studentName"); //convert the data all in the upper case
		 */
		theName = theName.toUpperCase();
		// create the message

		String result = "Hey mah man!!! from V3 " + theName;

		// add the message to the model

		model.addAttribute("message", result);

		return "helloworld";
	}

}