package com.jahadenglish.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJdbc {

	public static void main(String[] args) {
		
		//testing connection to database
		String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("connecting to database " + jdbcURL);
			
			//try to connect
			Connection conn = DriverManager.getConnection(jdbcURL, user, pass);
			
			System.out.println("connection sucsessfull");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
