package com.chainsys.libraryapplicationdao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapplicationmodel.User;

@WebServlet("/AdminSaveLibrary")
public class AdminSaveLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;
    User user = new User();
    LibraryImpl libraryImpl = new LibraryImpl();
	
	
    public AdminSaveLibrary() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		user.setName(name);
        String emailId = request.getParameter("EmailId");
        user.setEmailId(emailId);
        String password = request.getParameter("password");
        user.setPassword(password);
        String type = request.getParameter("type");
        user.setType(type);
        String phoneNo=request.getParameter("phonenumber");
        long phoneNumber=Long.parseLong(phoneNo);
        user.setPhoneNumber(phoneNumber);
        String location = request.getParameter("location");
        user.setLocation(location);
        try {
        	libraryImpl.saveLibrary(user);
            request.getRequestDispatcher("loginlibrarian.html").forward(request, response);
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("EmailId");
		user.setEmailId(emailId);
		String password = request.getParameter("password");
		user.setPassword(password);
		 try {
				String password1=libraryImpl.checkPassword(emailId);
			 if(password.equals(password1)) {
		            request.getRequestDispatcher("index.html").forward(request, response);
			 }else {
				 request.getRequestDispatcher("loginlibrarian.html").forward(request, response);
			 }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }	
		 }
}
