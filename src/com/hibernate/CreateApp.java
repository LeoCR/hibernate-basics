package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class CreateApp {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create a session
		Session session=factory.getCurrentSession();
		try {
			//use the sesion object to save Java Object
			System.out.println("Creating a new ");
			//create the objects
			//Instructor tempInstructor=new Instructor("Chad","Darby","darby@luv2code.com");
			//InstructorDetail tempInstructorDetail=new InstructorDetail("www.luv2code.com/youtube", "Luv 2 Code");
			//start a transaction
			Instructor tempInstructor=new Instructor("Madhu","Macgregor","madhu@gmail.com");
			InstructorDetail tempInstructorDetail=new InstructorDetail("www.youtube.com/madhu", "Guitar");
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			System.out.println("Saving Instructor: "+tempInstructor);
			//save the student object
			session.save(tempInstructor);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
