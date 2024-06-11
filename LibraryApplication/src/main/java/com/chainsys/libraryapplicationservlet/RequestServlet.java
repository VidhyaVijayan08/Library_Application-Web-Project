package com.chainsys.libraryapplicationservlet;

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

import com.chainsys.libraryapplicationdao.LibraryImpl;
import com.chainsys.libraryapplicationmodel.Lending;

@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Lending lending = new Lending();
	LibraryImpl libraryImpl = new LibraryImpl();
       

    public RequestServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
    	if(session!=null) {
    	String LenderId = request.getParameter("LenderId");
		int LenderId1 = Integer.parseInt(LenderId);
		System.out.println(LenderId + LenderId1);
		lending.setLenderId(LenderId1);
		String BookId = request.getParameter("BookId");
		int BookId1 = Integer.parseInt(LenderId);
		lending.setBookId(BookId1);
		System.out.println(BookId + BookId1);
		String Date = request.getParameter("Date");
		System.out.println(Date);
		lending.setBorrowerDate(Date);
		
		  try { 
			  System.out.println("hello");
//	          request.getRequestDispatcher("requestform.html").forward(request, response);

		    	libraryImpl.saveRequestForm(lending);

//		          request.getRequestDispatcher("home.html").forward(request, response);

		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }
    	}else {
			response.sendRedirect("requestform.html");
		}
    	response.sendRedirect("home.html");    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    {
	        Lending lending=new Lending();
	        String LenderId = request.getParameter("id");
	        System.out.println(LenderId);
			int lenderId1 = Integer.parseInt(LenderId);
	        lending.setLenderId(lenderId1);

	        
	        lending.setStatus(request.getParameter("approval"));
	        try 
	        {
	            libraryImpl.approveBorrower(lending);
	        } 
	        catch (ClassNotFoundException | SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        try 
	        {
	            List<Lending> list=libraryImpl.retrieveDetail();
	            request.setAttribute("list", list);
	            request.getRequestDispatcher("adminrequestview.jsp").forward(request, response);
//	            System.out.println(list);
	        }
	        catch (ClassNotFoundException | SQLException e)
	        {
	            e.printStackTrace();
	        }
	    

	}
    
	
	}
}
