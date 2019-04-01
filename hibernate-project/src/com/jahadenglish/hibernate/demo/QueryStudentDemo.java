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
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done!!!!");
		}
		finally {
			factory.close();
		}
		

	}

	

}