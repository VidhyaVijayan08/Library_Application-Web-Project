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
	static Lending lending = new Lending();
	static LibraryImpl libraryImpl = new LibraryImpl();

	public RequestServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);

		if (session != null) {
			String lenderId = request.getParameter("LenderId");
			String bookId = request.getParameter("BookId");
			String borrowDate = request.getParameter("Date");

			try {
				int lenderId1 = Integer.parseInt(lenderId);
				int bookId1 = Integer.parseInt(bookId);

				lending.setLenderId(lenderId1);
				lending.setBookId(bookId1);
				lending.setBorrowerDate(borrowDate);

				libraryImpl.saveRequestForm(lending);
				out.println("Lending request saved successfully.");
			} catch (NumberFormatException e) {
				out.println("Error: Unable to parse LenderId or BookId as integers.");
				e.printStackTrace();
			} catch (ClassNotFoundException | SQLException e) {
				out.println("Error: Unable to save lending request.");
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("requestform.html");
			return; // Stop further execution
		}

		response.sendRedirect("home.html");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{
			PrintWriter out = response.getWriter();
			String lenderId = request.getParameter("id");
			out.println(lenderId);
			int lenderId1 = Integer.parseInt(lenderId);
			lending.setLenderId(lenderId1);
			lending.setStatus(request.getParameter("approval"));
			try {
				libraryImpl.approveBorrower(lending);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			try {
				List<Lending> list = LibraryImpl.retrieveDetail();
				request.setAttribute("list", list);
				request.getRequestDispatcher("adminRequestView.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
