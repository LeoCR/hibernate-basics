package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class DeleteApp {
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
			//start a transaction
			session.beginTransaction();
			//get instructor by primary key / id
			int theId=2;
			Instructor tempInstructor=session.get(Instructor.class,theId);
			System.out.println("Found Instructor: "+ tempInstructor);
			if(tempInstructor!=null) {
				System.out.println("Deleting: "+tempInstructor);
				session.delete(tempInstructor);
			}
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
