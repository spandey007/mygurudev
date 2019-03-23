package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;
			// Start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Getting student id with:" + studentId);

			// retrieve student based on ID
			Student myStudent = session.get(Student.class, studentId);

			// update student first name
			System.out.println("Updating student");

			myStudent.setFirstName("Scooby");

			// commit transaction
			session.getTransaction().commit();

			// updating email id bulk update

			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Update email for all student");

			session.createQuery("update Student set email = 'foo@gmail.com' ").executeUpdate();

			// commit transaction

			session.getTransaction().commit();

			System.out.println("Done Here!...");

		} finally {
			factory.close();
		}

	}

}
