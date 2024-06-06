package com.chainsys.libraryapplicationdao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String username = request.getParameter("EmailId");
		 
		HttpSession session = request.getSession();
		if(username.equals("admin@gmail.com")) {
			session.setAttribute("name", name);
			response.sendRedirect("./StudentServlet");
		}else {
			response.sendRedirect("login.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        PrintWriter out=response.getWriter();
        String emailId=request.getParameter("emailId");
        String password=request.getParameter("password");
        try 
        {
            String password1=LibraryImpl.checkPassword(emailId);
        } 
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        HttpSession session=request.getSession();
        if(password.equals(password1))
        {
            session.setAttribute("emailId", emailId);
            response.sendRedirect("adminAfterLogin.jsp");

        }
        else
        {  
            RequestDispatcher dispatcher=request.getRequestDispatcher("adminLogin.jsp");
            out.println("<font color=red>Invalid User.</font>"); 
            dispatcher.include(request, response);
        }
    }



}
