package com.tutorial.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tutorial.dto.User;
import com.tutorial.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//servlet is the controller in MVC.  It is responsible for fetching model from DB using
		//business service and passing the model to view. Here the views are other JSPs
		//view will return the control back to client
		
		//get parameters from request object
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		
		//user password authentication
		LoginService service=new LoginService();
		boolean result=service.authenticate(userId, password);
		
		//get the model from database through business service
		User user=service.getUserDetails(userId);
		
		if (result)
		{
			
			
			//another way of passing model to scope object, don't need to
			//use dispatcher, sendRedirect will start another request and all the 
			//content of the previous request will be lost
			//in the view jsp file, can get the model from session.getAttribute instead

			request.getSession().setAttribute("user", user);
			//response.sendRedirect("success.jsp");
			
			
			//pass model to a scope object
			request.setAttribute("user", user);
			
			//map the model to view
			RequestDispatcher dispatcher=request.getRequestDispatcher("successel.jsp");
			
			//forward control to view jsp
			dispatcher.forward(request, response);
			
			return;
		}
		else
		{
			//direct the flow to a different view
			response.sendRedirect("login.jsp");
			return;
		}
		
	}

}
