package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class CreateInstructorApp {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create a session
		Session session=factory.getCurrentSession();
		try {
			//use the sesion object to save Java Object
			System.out.println("Creating a new ");
			//create the objects
			Instructor tempInstructor=new Instructor("Susan","Peralta","susanperalta@gmail.com");
			InstructorDetail tempInstructorDetail=new InstructorDetail("www.youtube.com/susan", "Video Games");
			//start a transaction
			session.beginTransaction();
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			System.out.println("Saving Instructor: "+tempInstructor);
			//save the student object
			session.save(tempInstructor);
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
