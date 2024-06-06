package com.chainsys.libraryapplicationdao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	         PrintWriter out = response.getWriter();
	         response.setContentType("text/html"); 
	         request.getSession(false).invalidate();
	         response.sendRedirect("financeHome.jsp");
	    }
		
//		response.setContentType("text/html");
//
//		PrintWriter out = response.getWriter();
//		HttpSession session = request.getSession(false);
//		session.invalidate();
//	//	out.print("You are Successfully Logged Out");
//	//	out.print("<a href='login.html'>index</a>");
//	    request.getRequestDispatcher("login.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
