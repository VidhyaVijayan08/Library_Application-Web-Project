package com.chainsys.libraryapplicationdao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapplicationmodel.User;
import com.chainsys.libraryapplicationutil.ConnectUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
LibraryImpl libraryImpl = new LibraryImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String name = request.getParameter("Name");
	    String mailId = request.getParameter("EmailId");
	    User user = new User();
	    user.setName(name);
	    System.out.println(name);
	    user.setEmailId(mailId);
	    String phoneNo=request.getParameter("PhoneNumber");
        long phoneNumber=Long.parseLong(phoneNo);
        user.setPhoneNumber(phoneNumber);
	    System.out.println(phoneNumber);

	    try {
	    	updateServlet(user);
	        List<User> list1 = LibraryImpl.retrieveDetails();
            request.setAttribute("list1", list1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    	    dispatcher.forward(request, response);
	  
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace(); 
	    }
	}

	
	    public static void updateServlet(User user) throws ClassNotFoundException, SQLException {
	    	System.out.println(user.getName());
	        Connection connection = ConnectUtil.getConnection();
	        String updateQuery = "UPDATE users SET user_name = ? WHERE phone_number = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setString(1, user.getName());
	        preparedStatement.setLong(2, user.getPhoneNumber());
		    int rows = preparedStatement.executeUpdate();
		    System.out.println(rows+" updated");
	        connection.close();
	    }
	
}
