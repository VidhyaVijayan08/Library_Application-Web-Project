package com.chainsys.libraryapplicationmodel;

import java.util.Arrays;

public class Book {
	  
	int bookId;
	String bookTitle;
	int authorId;
	String bookCategory;
	int publicationYear;
	String isbn;
	String bookSummary;
	int inStock;
	int bookRating;
	String bookReviews;
	byte[] bookCover;
	int availableBook;
	
	public Book() {
		
	}
	
	public Book(int bookId, String bookTitle, int authorId, String bookCategory, int publicationYear, String isbn,
			String bookSummary, int inStock, int bookRating, String bookReviews, byte[] bookCover, int availableBook) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.authorId = authorId;
		this.bookCategory = bookCategory;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
		this.bookSummary = bookSummary;
		this.inStock = inStock;
		this.bookRating = bookRating;
		this.bookReviews = bookReviews;
		this.bookCover = bookCover;
		this.availableBook = availableBook;
	}

	public int getAvailableBook() {
		return availableBook;
	}

	public void setAvailableBook(int availableBook) {
		this.availableBook = availableBook;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	public byte[] getBookCover() {
		return bookCover;
	}

	public void setBookCover(byte[] bookCover) {
		this.bookCover = bookCover;
	}

	public void setBookRating(int bookRating) {
		this.bookRating = bookRating;
	}
	
	//Getters and Setters
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookSummary() {
		return bookSummary;
	}
	public void setBookSummary(String bookSummary) {
		this.bookSummary = bookSummary;
	}
	
	public void setBookReviews(String bookReviews) {
		this.bookReviews = bookReviews;
	}
	
	public int getBookRating() {
		return bookRating;
	}
	
	public String getBookReviews() {
		return bookReviews;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", authorId=" + authorId + ", bookCategory="
				+ bookCategory + ", publicationYear=" + publicationYear + ", isbn=" + isbn + ", bookSummary="
				+ bookSummary + ", inStock=" + inStock + ", bookRating=" + bookRating + ", bookReviews=" + bookReviews
				+ ", bookCover=" + Arrays.toString(bookCover) + ", availableBook=" + availableBook + "]";
	}
}
