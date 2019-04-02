package com.jahadenglish.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jahadenglish.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start the transaction
			session.beginTransaction();
			
			//query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudent(theStudents);
			System.out.println();
			System.out.println();
			
			//query students with lastname = 'english'
			System.out.println("students with lastname = 'english'");
			theStudents = session.createQuery("from Student s where s.lastName='english'").getResultList();
			displayStudent(theStudents);
			
			System.out.println();
			System.out.println();
			
			//query students with lastname='english' or firstname='evione'
			System.err.println("students with lastname='english' or firstname='evione'");
			theStudents = session.createQuery("from Student s where s.lastName='english' OR s.firstName='evione'").getResultList();
			displayStudent(theStudents);
			
			System.out.println();
			System.out.println();
			
			//query students where email like '%gmail.com'
			System.out.println("students where email like '%gmail.com");
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			displayStudent(theStudents);
			
			System.out.println();
			System.out.println();
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done!!!!");
		}
		finally {
			factory.close();
		}
		

	}

	private static void displayStudent(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	

}
