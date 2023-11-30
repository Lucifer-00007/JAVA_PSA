package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getusers")
public class getusers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public getusers() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// out.print("hello");
		// out.print("<input type='text' />");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_users_data", "Admin",
					"Temp123#");

			Statement stmnt = con.createStatement();
			ResultSet result = stmnt.executeQuery("select * from users");

			out.print("<table>");
			out.print("<tr>");

			out.print("<th>");
			out.print("Name");
			out.print("</th>");

			out.print("<th>");
			out.print("Email");
			out.print("</th>");

			out.print("<th>");
			out.print("Phone");
			out.print("</th>");

			out.print("<th>");
			out.print("City");
			out.print("</th>");

			out.print("</tr>");

			while (result.next()) {
				out.print("<tr>");

				out.print("<td>");
				out.print(result.getString(1));
				out.print("</td>");

				out.print("<td>");
				out.print(result.getString(2));
				out.print("</td>");

				out.print("<td>");
				out.print(result.getString(3));
				out.print("</td>");

				out.print("<td>");
				out.print(result.getString(4));
				out.print("</td>");

				out.print("</tr>");
			}

			out.print("</table>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
