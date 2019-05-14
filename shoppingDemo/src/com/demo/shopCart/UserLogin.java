package com.demo.shopCart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.crud.User;
import com.demo.crud.UserDAO;

/**
 * Servlet implementation class UserLogin
 */

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new UserDAO().getUser(name, password);
        if (user != null) {
        	
            request.getSession().setAttribute("user", user);
            response.sendRedirect("listProduct.jsp");
            
        } else
            response.sendRedirect("login.jsp");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
