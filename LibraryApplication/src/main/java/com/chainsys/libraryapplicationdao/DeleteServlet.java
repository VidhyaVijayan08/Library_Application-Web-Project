package com.chainsys.libraryapplicationdao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapplicationmodel.User;



@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      User user = new User();
      LibraryImpl libraryImpl = new LibraryImpl();
   
    public DeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String name = request.getParameter("Name");
	        user.setName(name);
 
	        try {
	            libraryImpl.deleteServlet(user);;
	            PrintWriter writer = response.getWriter();
	            writer.println(user.getName() + " deleted");
	            List<User> list1 = LibraryImpl.retrieveDetails();
	            request.setAttribute("list1", list1);

	            request.getRequestDispatcher("index.jsp").forward(request, response);
	            
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
