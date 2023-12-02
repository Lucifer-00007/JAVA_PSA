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

@WebServlet("/update")
public class updateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateRegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parameter1 = request.getParameter("email");
		String parameter2 = request.getParameter("mobile");

		request.setAttribute("email", parameter1);
		request.setAttribute("mobile", parameter2);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parameter1 = request.getParameter("email");
		String parameter2 = request.getParameter("phone");
		
		//System.out.println("parameter1: "+ parameter1);
		//System.out.println("parameter2: "+ parameter2);
		
		DAOService service = new DAOServiceImpl();
		service.updateRegistration(parameter1, parameter2);

		ResultSet userData = service.readRegistration();
		request.setAttribute("user_info", userData);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/search_result.jsp");
		rd.forward(request, response);
	}

}
