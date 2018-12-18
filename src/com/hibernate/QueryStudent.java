package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class QueryStudent {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create a session
		Session session=factory.getCurrentSession();
		try {
			//start a transaction
			session.beginTransaction();
			//query students
			List<Student> students=session.createQuery("from Student").getResultList();
			//displayStudents(students);
			//query students: lastName=Walker
			students=session.createQuery("from Student s where s.lastName='Walker'").getResultList();
			//students=session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffi'").getResultList();
			//display the students
			//System.out.println("Students who have last name of Doe or First Name od Daffi");
			//System.out.println("Students who have email LIKE walker");
			//students=session.createQuery("from Student s where s.email LIKE '%walker%' ").getResultList();
			displayStudents(students);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student tempStudent:students) {
			System.out.println(tempStudent);
		}
	}

}
