package com.regapp.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DAOServiceImpl implements DAOService {
	
	@Override
	public boolean verifyCredentials(String email, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_login_user", "Admin123", "Temp123#");
			Statement stmnt = con.createStatement();
			ResultSet result = stmnt.executeQuery(" Select * from login_user where email='"+email+"' and password='"+pass+"' ");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void createRegistration(String name, String email, String phone, String city) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_users_data", "Admin123", "Temp123#");
			Statement stmnt = con.createStatement();
			stmnt.executeUpdate(" insert into user_data values('"+name+"', '"+email+"', '"+phone+"', '"+city+"') ");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet readRegistration() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_users_data", "Admin123", "Temp123#");
			Statement stmnt = con.createStatement();
			ResultSet allUsers = stmnt.executeQuery(" Select * from  user_data ");
			
			return allUsers;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void deleteRegistration(String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_users_data", "Admin123", "Temp123#");
			Statement stmnt = con.createStatement();
			stmnt.executeUpdate(" delete from user_data where email='"+email+"' ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_users_data", "Admin123", "Temp123#");
			Statement stmnt = con.createStatement();
			stmnt.executeUpdate("update user_data set phone='"+mobile+"' where email='"+email+"'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}	
