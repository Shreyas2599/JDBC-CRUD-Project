package com.student.manage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentToDB(Student st)
	{
		//jdbc code.....
		boolean f=false;
		try {
			Connection con=ConnectionProvider.createC();
			
			String q="insert into students(sname,sphone,scity) values(?,?,?)";
			
			//PreparedStatement
			PreparedStatement pstmt= con.prepareStatement(q);
			
			//set the values of parameter
			
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean deleteStudent(int userId) {
		//jdbc code.....
				boolean f=false;
				try {
					Connection con=ConnectionProvider.createC();
					
					String q="delete from students where sid=?";
					
					//PreparedStatement
					PreparedStatement pstmt= con.prepareStatement(q);
					
					//set the values of parameter
					
					pstmt.setInt(1,userId);
					
					
					//execute
					pstmt.executeUpdate();
					f=true;
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return f;
		 
		
	}

	public static void showAllStudents() {
		//jdbc code.....
		
		try {
			Connection con=ConnectionProvider.createC();
			
			String q="select * from students";
			
			//Statement
			Statement stmt=con.createStatement();
			stmt.executeQuery(q);
			
			//Resultset
			ResultSet set=stmt.executeQuery(q);
			while (set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				String city=set.getString("scity");
				
				System.out.println("Id :" +id);
				System.out.println("Name :"+name);
				System.out.println("Phone :"+phone);
				System.out.println("City :"+city);
				
				System.out.println("----------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}

	public static boolean updateStudent() {
		boolean f=false;
		try {
			Connection con=ConnectionProvider.createC();
			
			String q="update students set sname=?,sphone=?,scity=? where sid=?";
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter new Name");
			String name=br.readLine();
			
			
			System.out.println("Enter new Phone");
			String phone=br.readLine();
			
			
			System.out.println("Enter new City");
			String city=br.readLine();
			
			System.out.println("Enter new Id");
			int id=Integer.parseInt(br.readLine());
			
			//PreparedStatement
			PreparedStatement pstmt= con.prepareStatement(q);
			
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, city);
			pstmt.setInt(4, id);
			
			//execute
			pstmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}

	
	
}
