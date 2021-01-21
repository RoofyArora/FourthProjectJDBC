package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
	static Connection conn;
	
	public static Connection createC() {
		try
		{
			// load the driver		
			Class.forName("com.mysql.jdbc.Driver");
			
			// create the connection...
			String user="root";
			String password="system";
			String url="jdbc:mysql://localhost:3306/student_manage";
			
			conn = DriverManager.getConnection(url,user,password);
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
