package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {

			// option 2: Hibernate query with HQL
			// start transaction
			session.beginTransaction();
			int theid = 1;

			// get the instructor from db

			Query<Instructor> query = session.createQuery(
					"from Instructor i" + 
			" Join fetch i.courses " + 
							" where i.id = :theInstructorId",
					Instructor.class);

			// set the parameter

			query.setParameter("theInstructorId", theid);

			Instructor tempInstructor = query.getSingleResult();

			System.out.println("luv2code: Instructor Details" + tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();

			// get course for instructor

			System.out.println("\n\nThe session is now close!!\n\n");

			System.out.println("luv2code: Associated course : " + tempInstructor.getCourses());

			System.out.println("luv2code: Done Here!...");

		} finally {
			// session.close();
			factory.close();
		}

	}

}
