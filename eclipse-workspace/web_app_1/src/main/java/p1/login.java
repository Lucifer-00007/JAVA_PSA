package p1;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
			
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_login_user", "Admin", "Temp123#");
			
			Statement stmnt = con.createStatement();
			ResultSet result = stmnt.executeQuery(" select * from login_user where email='"+email+"' and password='"+pass+"' ");

			if(result.next()){
			    System.out.println("Successfully Logged In");
			}else {
			    System.out.println("Invalid credentials");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	}

}
