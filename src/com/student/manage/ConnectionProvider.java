package com.student.manage;
import java.sql.*;


public class ConnectionProvider {

	static Connection con;
	public static Connection createC(){
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String user="root";
			String password="Shreyas@123";
			String url="jdbc:mysql://localhost:3306/student_manage";
			
			 con=DriverManager.getConnection(url,user,password);	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
		
	}
}
