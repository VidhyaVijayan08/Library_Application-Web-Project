package com.chainsys.libraryapplicationdao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapplicationmodel.User;

 
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	LibraryImpl libraryImpl = new LibraryImpl();
       
    public SearchServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name= request.getParameter("Name");
		 user.setName(name);
		try 
	        {
	            List<User> list1 = LibraryImpl.searchServlet(user);
	            request.setAttribute("list1", list1);
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        } 
	        catch (ClassNotFoundException | SQLException e)
	        {
	            e.printStackTrace();
	        }	
		 }

@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
