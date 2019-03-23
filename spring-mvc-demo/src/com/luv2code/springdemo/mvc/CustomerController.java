package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//add init binder method
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
	//remove leading and trailing whitespace
	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	
	//resolve issue for validation
	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		System.out.println("inside customer controller");
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

		System.out.println("Last Name: |"+theCustomer.getLastName() + "|");
		
		System.out.println("result of the binding result + |"+theBindingResult);
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}
}
