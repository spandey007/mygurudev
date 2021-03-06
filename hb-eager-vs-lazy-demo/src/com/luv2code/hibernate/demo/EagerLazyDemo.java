package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();
			int theid = 1;

			// get the instructor from db
			Instructor tempInstructor = session.get(Instructor.class, theid);

			System.out.println("luv2code: Instructor Details" + tempInstructor);

			System.out.println("luv2code: Associated course : " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();

			//close the session
			session.close();
			
			
			// get course for instructor
			
			System.out.println("\n\nThe session is now close!!\n\n");

			System.out.println("luv2code: Associated course : " + tempInstructor.getCourses());

			System.out.println("luv2code: Done Here!...");

		} finally {
//			session.close();
			factory.close();
		}

	}

}
