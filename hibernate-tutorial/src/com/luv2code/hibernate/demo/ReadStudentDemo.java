package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {
			// use session object to save java object
			System.out.println("Creating a new student object");

			// create a student object
			Student tempSrtudent = new Student(/* 1, */"Daffy", "duck", "daffy@luv2code.com");

			System.out.println("Creating a transaction");

			// Start a transaction
			session.beginTransaction();

			System.out.println("Saving the student");

			// save the student object

			System.out.println(tempSrtudent);
			session.save(tempSrtudent);

			// commit the transaction
			session.getTransaction().commit();

			// new code

			// find out what the primary key is

			System.out.println("Save Student. Genrated Id:" + tempSrtudent.getId());

			// now get a new session and
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retreive the student based on id:primary key
			System.out.println("Getting student with id");

			Student myStudent = session.get(Student.class, tempSrtudent.getId());

			System.out.println("Get student complete:" + myStudent);

			// commit transaction

			session.getTransaction().commit();

			System.out.println("Done Here!...");

		} finally {
			factory.close();
		}

	}

}
