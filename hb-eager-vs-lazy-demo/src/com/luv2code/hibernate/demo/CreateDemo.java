package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {

			/*
			 * // create the object Instructor tempInstructor = new Instructor("Chad",
			 * "Darby", "darby@lov2code.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("luv2code.com/youtube", "luv 2 code!!!"); // associate the
			 * object together
			 */

			// create the object
			Instructor tempInstructor = new Instructor("Sarva", "Pandey", "vishu.anand007@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com", "Fuck BOI!!!!!");
			// associate the object together

			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start transaction
			session.beginTransaction();

			// save transaction

			// this will also save details object cause cascade type ALL
			System.out.println("Save Instructor " + tempInstructor);
			session.save(tempInstructor);
			// commit transaction
			session.getTransaction().commit();

			// commit the transaction

			System.out.println("Done Here!...");

		} finally {
			factory.close();
		}

	}

}
