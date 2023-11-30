package p2;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getData")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servlet1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = (String)request.getParameter("data");
		
		RequestDispatcher rd =  request.getRequestDispatcher("destinationPage.html");
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputData = request.getParameter("inputData");
		
		// Pass the data to the display page using request attributes
        request.setAttribute("data", inputData);
        
        //call the second servlet and transfer data 
        RequestDispatcher rd =  request.getRequestDispatcher("setData");
        rd.forward(request, response);
        
	}

}
