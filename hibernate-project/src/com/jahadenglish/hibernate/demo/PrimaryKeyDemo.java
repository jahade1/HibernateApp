package com.jahadenglish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jahadenglish.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory
				SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					//use the session object to save the java object
					
					//create the student object
					System.out.println("creating 3 student object");
					Student tempStudent1 = new Student("kenya", "english", "kenya.english@gmail.com");
					Student tempStudent2 = new Student("pierre", "corielan", "pierre.corielan@gmail.com");
					Student tempStudent3 = new Student("evione", "gramhnm", "evione.gramhnm@gmail.com");
					//start the transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("saving the student/.....");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					//commit transaction
					session.getTransaction().commit();
					System.out.println("done should be in the database go check!!!!");
				}
				finally {
					factory.close();
				}
				

	}

}
