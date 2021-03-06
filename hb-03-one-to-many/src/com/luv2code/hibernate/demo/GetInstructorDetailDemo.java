package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get Instructor detail by primary key(id)
			int theId = 299;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print instructor detail
			System.out.println("Instructor details" + tempInstructorDetail);

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			// print associated instructor

			System.out.println("Instructor object" + tempInstructorDetail.getInstructor());

			// commit transaction
			session.getTransaction().commit();

			// commit the transaction

			System.out.println("Done Here!...");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			// handle connection leak
			session.clear();
			factory.close();
		}

	}

}
