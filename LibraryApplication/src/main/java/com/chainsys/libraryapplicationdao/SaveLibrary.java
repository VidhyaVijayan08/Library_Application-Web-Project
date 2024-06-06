package com.chainsys.libraryapplicationdao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Library;

import com.chainsys.libraryapplicationmodel.User;

@WebServlet("/SaveLibrary")
public class SaveLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	LibraryImpl libraryImpl = new LibraryImpl();
			
    public SaveLibrary() {
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
//        	  List<User> list1 = LibraryImpl.retrieveDetails();
//              request.setAttribute("list1", list1);
              request.getRequestDispatcher("login.html").forward(request, response);
//            List<User> list1 = LibraryImpl.retrieveDetails();
//            request.setAttribute("list1", list1);
//            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("EmailId");
		user.setEmailId(emailId);
		String password = request.getParameter("password");
		user.setPassword(password);
		 try {
				String password1=libraryImpl.checkPassword(emailId);
			 if(password.equals(password1)) {
		            request.getRequestDispatcher("home.html").forward(request, response);
			 }else {
				 request.getRequestDispatcher("login.html").forward(request, response);
			 }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }	
	}

}
