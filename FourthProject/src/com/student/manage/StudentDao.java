package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;


public class StudentDao {
	
	public static boolean insertStudentToDB(Student st)
	{
		boolean f=false;
		try
		{
			// jdbc code
			Connection conn=CP.createC();
			String q="insert into students(sname,sphone,scity) values(?,?,?)";
			// PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(q);
			//set the value of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			// execute
			pstmt.executeUpdate();
			f=true;

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean deleteStudent(int userId) {
		
		boolean f=false;
		try
		{
			// jdbc code
			Connection conn=CP.createC();
			String q="delete from students where sid=?";
			// PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(q);
			//set the value of parameter
			pstmt.setInt(1, userId);
			
			// execute
			pstmt.executeUpdate();
			f=true;

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		

	}

	public static void showAllStudent() {
		
		boolean f=false;
		try
		{
			// jdbc code
			Connection conn = CP.createC();
			String q = "select * from students;";
			Statement stmt=(Statement) conn.createStatement();
			
			ResultSet rs=stmt.executeQuery(q);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String phone=rs.getString(3);
				String city=rs.getString("scity");
				
				System.out.println("ID : "+id);
				System.out.println("Name : "+name);
				System.out.println("Phone : "+phone);
				System.out.println("City : "+city);
				System.out.println("++++++++++++++++++++++++++++");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		
	}

}
