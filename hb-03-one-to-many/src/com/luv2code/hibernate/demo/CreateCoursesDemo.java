package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

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

			// create some courses
			Course tempCourse1 = new Course("Air Guitar - the ultimate guide");
			Course tempCourse2 = new Course("The pinball Master Class");
			
			
			// add those courses into instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			
			// save those courses

			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// commit transaction
			session.getTransaction().commit();

			// commit the transaction

			System.out.println("Done Here!...");

		} finally {
			session.close();
			factory.close();
		}

	}

}
