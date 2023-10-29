package app_java_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class createUser {
	public static void main(String[] args) {
		 try { 
				//connect to the database
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_users_data", "Admin", "Temp123#");
		        
		        Scanner scan = new Scanner(System.in);
		        
		        System.out.print("Enter your name: ");
		        String name = scan.nextLine();
		        
		        System.out.print("Enter your email: ");
		        String email = scan.nextLine();
		        
		        System.out.print("Enter your phone number: ");
		        String mobile = scan.nextLine();		        
		
		        System.out.print("Enter your city: ");
		        String city = scan.nextLine();		        
		        
		        scan.close();
		        
		        //Write and run SQL statements
		        Statement stmnt = con.createStatement();
		        stmnt.executeUpdate("insert into users values(' "+name+" ', ' "+email+" ', ' "+mobile+" ', ' "+city+" ')");
		        
		        System.out.print("User data Added To Database Successfully!");	
		        //Close Connection
		        con.close();
		    }catch (Exception e) {
		        e.printStackTrace();
		    }	
	}
}
