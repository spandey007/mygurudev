package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the Customer DAO
	/*
	 * @Autowired private CustomerDao customerDao;
	 */
	// inject Customer Service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// get the customers from DAO

		// List<Customer> theCustomers = customerDao.getCustomers();

		// get the customer from service
		List<Customer> theCustomers = customerService.getCustomers();

		// add the customers to spring mvc Model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create new model attribute to bind data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		// save the customer using service
		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get customer from service
		
		Customer theCustomer= customerService.getCustomer(theId);
		
		//set customer to model attribute to pre populate the from
		
		theModel.addAttribute("customer",theCustomer);
		
		//send over to our form	
		
		return "customer-form";

	}

	@GetMapping("/delete")
	public String deletCustomer(@RequestParam("customerId")int theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
