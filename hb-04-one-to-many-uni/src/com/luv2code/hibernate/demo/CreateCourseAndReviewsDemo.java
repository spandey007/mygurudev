package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// Create a course

			Course tempCourse = new Course("Pacman - How to score million points");

			// add some reviews to the course

			tempCourse.add(new Review("Greate Course.. i loved it"));
			tempCourse.add(new Review("Cool Course"));
			tempCourse.add(new Review("What a dumb course"));

			// save course and cascade all
			System.out.println("Saving the course");
			session.save(tempCourse);

			System.out.println("Reviews: " + tempCourse.getReviews());
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
