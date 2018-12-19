package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class DeleteMaryStudentApp {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		//create a session
		Session session=factory.getCurrentSession();
		try {
			//start a transaction
			session.beginTransaction();
			//get the student mary from database
			int studentId=2;
			Student tempStudent=session.get(Student.class,studentId);
			System.out.println("Loaded student: "+tempStudent);
			System.out.println("Courses: "+tempStudent.getCourses());
			//delete student
			System.out.println("Deleting student: "+tempStudent);
			session.delete(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} 
		catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
