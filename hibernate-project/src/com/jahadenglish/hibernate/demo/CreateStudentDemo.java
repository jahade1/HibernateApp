package com.jahadenglish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jahadenglish.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save the java object
			
			//create the student object
			System.out.println("creating new student object");
			Student tempStudent = new Student("paul", "english", "jahad.english@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student/.....");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done should be in the database go check!!!!");
		}
		finally {
			factory.close();
		}
		

	}

	private static Student Student(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return null;
	}

}
