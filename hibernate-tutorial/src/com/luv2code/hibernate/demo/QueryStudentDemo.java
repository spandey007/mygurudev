package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {

			// Start a transaction

			session.beginTransaction();

			// query the student

			List<Student> listStudent = session.createQuery("from Student").getResultList();

			// display the student

			displayStudent(listStudent);

			// query student with last name bhandgar

			listStudent = session.createQuery("from Student where lastName = 'Bandgar'").getResultList();

			System.out.println("Bhandgar details");

			System.out.println();
			System.out.println();

			displayStudent(listStudent);

			// get student bhandgar or baba
			System.out.println();
			System.out.println();
			System.out.println("Baba Bhandgar details");

			listStudent = session.createQuery("from Student where lastName = 'Bandgar' or lastName = 'Baba'")
					.getResultList();

			displayStudent(listStudent);

			// get list with email with luv2code.com in it
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("details with email");
			listStudent = session.createQuery("from Student s where s.email like '%luv2code.com'").getResultList();
			displayStudent(listStudent);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done Here!...");

		} finally {
			factory.close();
		}

	}

	private static void displayStudent(List<Student> listStudent) {
		for (Student tempStudent : listStudent) {
			System.out.println(tempStudent);
		}
	}

}
