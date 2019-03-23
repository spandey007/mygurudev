package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	// need to inject session factort

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	// @Transactional removed because we will use in service layer
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create query

		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute the query get the result list

		List<Customer> customer = theQuery.getResultList();

		// return the results

		return customer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		//currentSession.save(theCustomer);
		
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		// get current hiernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get customer list
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		//get current hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
	
		//delet customer
		Query theQuery = currentSession.createQuery("delete from Customer where id =:customerId" );
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

}
