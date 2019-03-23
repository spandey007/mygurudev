package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// Create a course

			Course tempCourse = new Course("Pacman - How to score million points");


            // save course and cascade all
			System.out.println("\nSaving the course");
			session.save(tempCourse);

			//create the students
			
			Student temStudent1= new Student("John","Doe","john@luv2code.com");
			Student temStudent2= new Student("Mary	","Public","mary@luv2code.com");
			
			//add the student to the courses
			
			temStudent1.addCourses(tempCourse);
			temStudent2.addCourses(tempCourse);
			
			//save the students
			System.out.println("\n Saving students");
			session.save(temStudent1);
			session.save(temStudent2);
			System.out.println("\n Saved students: "+tempCourse.getStudents());
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
