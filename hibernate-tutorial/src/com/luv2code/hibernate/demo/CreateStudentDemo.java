package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			//use session object to save java object
			System.out.println("Creating a new student object");
			Student tempSrtudent = new Student(/*1,*/"Paul","Wall","paul@luv2code.com");
			//create a student object
			System.out.println("Creating a transaction");
			session.beginTransaction();
			//Start a transaction
			System.out.println("Saving the student");
			session.save(tempSrtudent);
			//save the student object
			session.getTransaction().commit();
			
			//commit the transaction
			
			System.out.println("Done Here!...");
			
		}
		finally {
			factory.close();
		}

	}

}
