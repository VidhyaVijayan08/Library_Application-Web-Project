package com.chainsys.libraryapplicationservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewServlet() {
        super();
    } 


	     @Override
	     protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	         try {
	             RequestDispatcher dispatcher = request.getRequestDispatcher("viewBookCategory.jsp");
	             dispatcher.forward(request, response);
	         } catch (ServletException | IOException e) {
	             e.printStackTrace(); 
	         }
	     


	     }}