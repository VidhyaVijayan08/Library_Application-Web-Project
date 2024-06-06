package com.chainsys.libraryapplicationdao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.chainsys.libraryapplicationmodel.Book;
import com.mysql.cj.jdbc.Blob;


@WebServlet("/AdminServlet")
@MultipartConfig
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LibraryImpl libraryImpl = new LibraryImpl();
       
  
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookTitle = request.getParameter("bookTitle");
		int authorId = Integer.parseInt(request.getParameter("authorId"));
		String bookCategory= request.getParameter("bookCategory");
		int publicationYear = Integer.parseInt(request.getParameter("publicationYear"));
		String isbn = request.getParameter("isbn");
		String bookSummary = request.getParameter("bookSummary");
		int bookRating = Integer.parseInt(request.getParameter("bookRating"));
		String bookReview = request.getParameter("bookReview");
		InputStream inputStream = null;
		Part filePart = request.getPart("filePart");
		if(filePart != null) {
			System.out.println(filePart.getName());
			inputStream = filePart.getInputStream();
		}
		byte[] images =null;
		if(inputStream !=null) {
			images = inputStream.readAllBytes();
		}
		Book book = new Book();
	    book.setBookId(bookId);
	    book.setBookTitle(bookTitle);
	    book.setAuthorId(authorId);
	    book.setBookCategory(bookCategory);
	    book.setPublicationYear(publicationYear);
	    book.setIsbn(isbn);
	    book.setBookSummary(bookSummary);
	    book.setBookRating(bookRating);
	    book.setBookReviews(bookReview);
	    book.setBookCover(images);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookTitle = request.getParameter("bookTitle");
		int authorId = Integer.parseInt(request.getParameter("authorId"));
		String bookCategory= request.getParameter("bookCategory");
		int publicationYear = Integer.parseInt(request.getParameter("publicationYear"));
		String isbn = request.getParameter("isbn");
		String bookSummary = request.getParameter("bookSummary");
		int bookRating = Integer.parseInt(request.getParameter("bookRating"));
		String bookReview = request.getParameter("bookReview");
		int inStock = Integer.parseInt(request.getParameter("bookInStock"));
		int availableBook = Integer.parseInt(request.getParameter("availableBook"));
		
		InputStream inputStream = null;
		Part filePart = request.getPart("filePart");
		if(filePart != null) {
			System.out.println(filePart.getName());
			inputStream = filePart.getInputStream();
		}
		byte[] images =null;
		if(inputStream !=null) {
			images = inputStream.readAllBytes();
		}
		Book book = new Book();
	    book.setBookId(bookId);
	    book.setBookTitle(bookTitle);
	    book.setAuthorId(authorId);
	    book.setBookCategory(bookCategory);
	    book.setPublicationYear(publicationYear);
	    book.setIsbn(isbn);
	    book.setBookSummary(bookSummary);
	    book.setBookRating(bookRating);
	    book.setBookReviews(bookReview);
	    book.setInStock(inStock);
	    book.setAvailableBook(availableBook);
	    book.setBookCover(images);
	    try {
			libraryImpl.saveBook(book);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/BookServlet");
	        dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
