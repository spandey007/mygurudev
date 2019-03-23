package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesFormMaryDemo {

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

			int id = 2;
			//get student mary from database
			
			Student tempStudent = session.get(Student.class, id);
			
			System.out.println("\nStudent Load "+tempStudent);
			System.out.println("\nCourse: "+tempStudent.getCourses());
			
			//create some more courses
			
			Course tempCourse = new Course("Rubik's Cube: How to solve fast");
			Course tempCourse2 = new Course("Attari 2600- How to develop a game");			
			
			
			//add mary to those courses
			
			tempCourse.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			//save the courses
			System.out.println("\nSaving the courses :"+tempCourse+"\n"+tempCourse2);
			session.save(tempCourse);
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
