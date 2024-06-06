package com.chainsys.libraryapplicationdao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.libraryapplicationmodel.User;

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public ReadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			HttpSession session = request.getSession(false);
			
			if(session!= null) {
				String name=(String) session.getAttribute("Name");
				out.print("Welcome To Profile Servlet " + name);
				try  
		        {
		            List<User> list1 = LibraryImpl.retrieveDetails();
		            request.setAttribute("list1", list1);
		            request.getRequestDispatcher("index.jsp").forward(request, response);
		        } 
		        catch (ClassNotFoundException | SQLException e)
		        {
		            e.printStackTrace();
		        }
			}else {
				response.sendRedirect("login.html");
			}
			out.print("<a href='logins.html'>Index</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
