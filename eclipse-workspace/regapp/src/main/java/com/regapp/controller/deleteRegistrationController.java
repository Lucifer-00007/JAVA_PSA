package com.regapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.regapp.model.DAOService;
import com.regapp.model.DAOServiceImpl;


@WebServlet("/delete")
public class deleteRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("email");
		System.out.println("parameter: " + parameter);
		
		DAOService service = new DAOServiceImpl();
		service.deleteRegistration(parameter);
		
		ResultSet userData = service.readRegistration();
		request.setAttribute("user_info", userData);	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/search_result.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
