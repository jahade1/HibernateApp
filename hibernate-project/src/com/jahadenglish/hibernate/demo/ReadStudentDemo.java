package com.jahadenglish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jahadenglish.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save the java object
			
			//create the student object
			System.out.println("creating new student object");
			Student tempStudent = new Student("Nippsey", "Hustle", "Nippsey.Hustle@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student/.....");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			//new code
			System.out.println("saved student generated id: " + tempStudent.getId());
			
			//get a new session and start transaction
			//always use transactions for saves updates and reads from the database
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\ngetting student with the id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: " + myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
		

	}

	

}
