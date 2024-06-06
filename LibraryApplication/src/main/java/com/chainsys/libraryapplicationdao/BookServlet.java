package com.chainsys.libraryapplicationdao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapplicationmodel.Book;
 
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve book details from the database
            List<Book> bookList = LibraryImpl.getAllBooks(null);
            
            // Set the attribute for the JSP page
            request.setAttribute("bookList", bookList);

            // Forward to JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("view_books.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    private List<Book> retrieveBookDetails() throws SQLException, ClassNotFoundException {
        // Use LibraryImpl to retrieve book details from the database
        LibraryImpl libraryImpl = new LibraryImpl();
        return libraryImpl.getAllBooks(null); // Assuming this method retrieves all books from the database
    }
}
