package com.chainsys.libraryapplicationmodel;

public class Lending {
	int lendingId;
	int bookId;
	int lenderId;
	int borrowerId;
	String borrowerDate;
	String dueDate;
	String status;
	int fine;

	//Getters and Setters
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getLenderId() {
		return lenderId;
	}
	public void setLenderId(int lenderId) {
		this.lenderId = lenderId;
	}
	public int getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}
	public String getBorrowerDate() {
		return borrowerDate;
	}
	public void setBorrowerDate(String borrowerDate) {
		this.borrowerDate = borrowerDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getFine() {
		return fine;
	}

	public int getLendingId() {
		return lendingId;
	}

	public void setLendingId(int lendingId) {
		this.lendingId = lendingId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	
	public Lending() {
		
	}
	
	public Lending(int lendingId, int bookId, int lenderId, int borrowerId, String borrowerDate, String dueDate, String status, int fine) {
		super();
		this.lendingId = lendingId;
		this.bookId = bookId;
		this.lenderId = lenderId;
		this.borrowerId = borrowerId;
		this.borrowerDate = borrowerDate;
		this.dueDate = dueDate;
		this.status = status;
		this.fine = fine;
	}

	@Override
	public String toString() {
		return "Lending [lendingId=" + lendingId + ", bookId=" + bookId + ", lenderId=" + lenderId + ", borrowerId="
				+ borrowerId + ", borrowerDate=" + borrowerDate + ", dueDate=" + dueDate + ", status=" + status
				+ ", fine=" + fine + "]";
	}
	
	
}
