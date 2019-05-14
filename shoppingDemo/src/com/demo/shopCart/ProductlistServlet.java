package com.demo.shopCart;
import com.demo.crud.Products;
import com.demo.crud.ProductsDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProServlet
 */

public class ProductlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	List<Products> products = new ProductsDAO().view();
    	 
        request.setAttribute("products", products);
        
        RequestDispatcher rd = request.getRequestDispatcher("listProduct.jsp");
     
        rd.forward(request, response);
        
    	
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		doPost(request, response);

    }


}
