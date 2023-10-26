package app_java_9;

import java.sql.*;

public class A {
	public static void main(String[] args) {
		 try {
			//connect to the database
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coinBase", "root", "root");
	        System.out.println(con);
	
	        //Write and run SQL statements
	        Statement stmnt = con.createStatement();
	        stmnt.executeUpdate("insert into coindata values(2, 'tail')");
	
	        //Close Connection
	        con.close();
	    }catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
