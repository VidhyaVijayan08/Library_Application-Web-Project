package com.chainsys.libraryapplicationdao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.chainsys.libraryapplicationmodel.Book;
import com.chainsys.libraryapplicationmodel.Lending;
import com.chainsys.libraryapplicationmodel.User;
import com.chainsys.libraryapplicationutil.ConnectUtil;

public class LibraryImpl implements LibraryDAO{
 
	public void saveLibrary(User user) throws ClassNotFoundException, SQLException {
		 Connection con = ConnectUtil.getConnection();
	        String add = "insert into users(user_name,mail_id, user_password, user_type, phone_number, location,status)values(?,?,?,?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(add);
	            user.setName(user.getName());
	            System.out.println("Getting Student name" + user.getName());
	            ps.setString(1, user.getName());
	            ps.setString(2, user.getEmailId());
	            ps.setString(3, user.getPassword());
	            ps.setString(4, user.getType());
	            ps.setLong(5, user.getPhoneNumber());
	            ps.setString(6, user.getLocation());
	            ps.setInt(7, 1);
	            System.out.println("Setting Student name : " + user.getName());
	            int rows = ps.executeUpdate();
	            System.out.println("In Add movie Servlet.." + rows);
	}

	public void saveRequest(Lending lending) throws ClassNotFoundException, SQLException {
	    Connection con = ConnectUtil.getConnection();
	    String add = "INSERT INTO lending_details (book_id, user_id, borrow_date, due_date, status, fine) VALUES (?, ?, ?, DATE_ADD(?, INTERVAL 30 DAY), ?, ?)";
	    PreparedStatement ps = con.prepareStatement(add);

	    ps.setInt(1, lending.getBookId());
	    ps.setInt(2, lending.getLenderId()); 
	    
	    String borrowerDate = lending.getBorrowerDate();
	    if (borrowerDate == null || borrowerDate.isEmpty()) {
	        borrowerDate = getCurrentDate(); 
	    }
	    ps.setString(3, borrowerDate);

	    ps.setString(4, borrowerDate);

	    ps.setString(5, "Pending");
	    ps.setInt(6, 0);

	    int rows = ps.executeUpdate();
	    System.out.println("Inserted " + rows + " row(s) into lending_details table.");

	    ps.close();
	    con.close();
	}

	 private String getCurrentDate() {
	        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	    }

	
	public void saveRequestForm(Lending lending) throws ClassNotFoundException, SQLException {
		 Connection con = ConnectUtil.getConnection();
	        String add = "insert into lending_details(book_id,user_id, borrow_date,status,fine)values(?,?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(add);
	         
	            System.out.println("Getting Student name" + lending.getBookId());
	            ps.setInt(1, lending.getBookId());
	            ps.setInt(2, lending.getLenderId());
	            ps.setString(3, lending.getBorrowerDate());
	            ps.setString(4, "Pending");
	            ps.setInt(5, 0);
	            System.out.println("Setting Lender ID : " + lending.getLenderId());
	            int rows = ps.executeUpdate();
	            System.out.println("In Add movie Servlet.." + rows);
	}
	
	public void saveBook(Book book) throws ClassNotFoundException, SQLException {
		 Connection con = ConnectUtil.getConnection();
	        String add = "insert into book_details(book_id,book_title,author_id,book_category,publication_year,isbn,book_summary,book_rating,book_reviews,book_cover,in_stock,available_books)values(?,?,?,?,?,?,?,?,?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(add);
	            book.setBookTitle(book.getBookTitle());
	            System.out.println("Getting Book Title" + book.getBookTitle());
	            ps.setInt(1, book.getBookId());
	            ps.setString(2, book.getBookTitle());
	            ps.setInt(3, book.getAuthorId());
	            ps.setString(4, book.getBookCategory());
	            ps.setLong(5, book.getPublicationYear());
	            ps.setString(6, book.getIsbn());
	            ps.setString(7, book.getBookSummary());
	            ps.setInt(8, book.getBookRating());
	            ps.setString(9, book.getBookReviews());
	            ps.setBytes(10, book.getBookCover());
	            ps.setInt(11, book.getInStock());
	            ps.setInt(12, book.getAvailableBook());
	            System.out.println("Setting Book title : " + book.getBookTitle());
	            int rows = ps.executeUpdate();
	            System.out.println("In Add movie Servlet.." + rows);
	}
	

//	public void saveLibrary(Book book) throws ClassNotFoundException, SQLException {
//		 Connection con = ConnectUtil.getConnection();
//	        String add = "insert into users(book_id,book_title,author_id,book_category, publication_year, isbn,book_summary,book_rating,book_reviews,in_stock,availableBooks)values(?,?,?,?,?,?,?)";
//	        PreparedStatement ps = con.prepareStatement(add);
//	            book.setBookTitle(book.getBookTitle());
//	            System.out.println("Getting Book Title" + book.getBookTitle());
//	            ps.setString(1, user.getName());
//	            ps.setString(2, user.getEmailId());
//	            ps.setString(3, user.getPassword());
//	            ps.setString(4, user.getType());
//	            ps.setLong(5, user.getPhoneNumber());
//	            ps.setString(6, user.getLocation());
//	            ps.setInt(7, 1);
//	            System.out.println("Setting Student name : " + user.getName());
//	            int rows = ps.executeUpdate();
//	            System.out.println("In Add movie Servlet.." + rows);
//	}
	
	public static String checkPassword(String emailId, String password) throws ClassNotFoundException, SQLException {
		String userType=null;
		Connection connection = ConnectUtil.getConnection();
		String select = "select user_type from users where lower(mail_id)=lower(?) and lower(user_password)=lower(?) and status=1";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1,emailId);
		prepareStatement.setString(2,password);
		System.err.print("The emailId "+ emailId);
		System.err.print("The password "+password);
		System.err.print("The prepared statement "+prepareStatement);
    	ResultSet resultSet = prepareStatement.executeQuery(); 
    	while (resultSet.next()) {
            userType= resultSet.getString(1);
    	}
        System.out.println(resultSet+" retrieved");		
        return userType;
	}
	
	public void deleteServlet(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = ConnectUtil.getConnection();
		String save="update users set status=0 where user_id=? and status=1";
        PreparedStatement prepareStatement = con.prepareStatement(save);
        prepareStatement.setInt(1, id);
        int rows = prepareStatement.executeUpdate();
        System.out.println("Deleted_id "+ id);
        System.out.println("prepareStatement "+prepareStatement);
    	System.out.println(rows + " deleted");
	}
	
	public static List<User> retrieveDetails() throws ClassNotFoundException, SQLException 
    {
        ArrayList<User> list=new ArrayList<>();
        Connection connection=ConnectUtil.getConnection();
        String select="select user_name,mail_id, user_password, user_type, phone_number, location from users where status =1";
        PreparedStatement prepareStatement=connection.prepareStatement(select);
        ResultSet resultSet=prepareStatement.executeQuery();
        while(resultSet.next())
        {
            String name=resultSet.getString(1);
            String emailId=resultSet.getString(2);
            String password=resultSet.getString(3);
            String type = resultSet.getString(4);
            Long phoneNumber = resultSet.getLong(5);
            String location = resultSet.getString(6);
            
            User user=new User();
            user.setName(name);
            user.setEmailId(emailId);
            user.setPassword(password);
            user.setType(type);
            user.setPhoneNumber(phoneNumber);
            user.setLocation(location);
            list.add(user);
        }
        connection.close();
        return list;
    }
	
	public static List<Lending> retrieveDetail() throws ClassNotFoundException, SQLException 
    {
        ArrayList<Lending> list=new ArrayList<>();
        Connection connection=ConnectUtil.getConnection();
        String select="select lending_id, book_id, user_id, due_date, borrow_date, status, fine from lending_details ";
        PreparedStatement prepareStatement=connection.prepareStatement(select);
        ResultSet resultSet=prepareStatement.executeQuery();
        while(resultSet.next())
        {
        	int lendingId = resultSet.getInt(1);
            int bookId=resultSet.getInt(2);
            int lenderId=resultSet.getInt(3);
            String dueDate=resultSet.getString(4);
            String borrowDate = resultSet.getString(5);
            String status = resultSet.getString(6);
            int fine = resultSet.getInt(7);

            Lending lending=new Lending();
            lending.setLendingId(lendingId);

            lending.setLenderId(lenderId);
            lending.setBookId(bookId);
            lending.setDueDate(dueDate);
            lending.setBorrowerDate(borrowDate);
            lending.setStatus(status);
            lending.setFine(fine);
            list.add(lending);
        }
        connection.close();
        return list;
    }
	
	public static List<User> searchServlet(User user) throws ClassNotFoundException, SQLException {
        ArrayList<User> list=new ArrayList<>();
	  	Connection connection = ConnectUtil.getConnection();
        System.out.println(connection);
        String save="SELECT  user_name,mail_id, user_password , user_type, phone_number, location FROM users where user_name=? and status =1";
        PreparedStatement prepareStatement = connection.prepareStatement(save);
        prepareStatement.setString(1, user.getName());
    	ResultSet rows = prepareStatement.executeQuery(); 
    	while (rows.next()) {
    		 String name=rows.getString(1);
             String emailId=rows.getString(2);
             String password=rows.getString(3);
             String type = rows.getString(4);
             Long phoneNumber = rows.getLong(5);
             String location = rows.getString(6);
             user.setName(name);
             user.setEmailId(emailId);
             user.setPassword(password);
             user.setType(type);
             user.setPhoneNumber(phoneNumber);
             user.setLocation(location);
             list.add(user);
    	}
        System.out.println(rows+" retrieved");
		return list;
}
	
	
	public static List<Book> searchServlet(Book book) throws ClassNotFoundException, SQLException {
        List<Book> bookList = new ArrayList<>();
	  	Connection connection = ConnectUtil.getConnection();
        System.out.println(connection);
        String save="SELECT  book_id, book_title, author_id, book_category, publication_year, isbn, book_summary, book_rating, book_reviews, book_cover,available_books FROM book_details where book_title=?";
        PreparedStatement prepareStatement = connection.prepareStatement(save);
        prepareStatement.setString(1, book.getBookTitle());
    	ResultSet rows = prepareStatement.executeQuery(); 
    	while (rows.next()) {
    		  book.setBookId(rows.getInt("book_id"));
              book.setBookTitle(rows.getString("book_title"));
              book.setAuthorId(rows.getInt("author_id"));
              book.setBookCategory(rows.getString("book_category"));
              book.setPublicationYear(rows.getInt("publication_year"));
              book.setIsbn(rows.getString("isbn"));
              book.setBookSummary(rows.getString("book_summary"));
              book.setBookRating(rows.getInt("book_rating"));
              book.setBookReviews(rows.getString("book_reviews"));
              book.setAvailableBook(rows.getInt("available_books"));
              book.setBookCover(rows.getBytes("book_cover"));
              bookList.add(book);
    	}
        System.out.println(rows+" retrieved");
		return bookList;
}
	
	
	
    public void removeUser(User user) throws ClassNotFoundException, SQLException 
    {
        Connection connection=ConnectUtil.getConnection();
        String update="update users set status=? where user_id=? and status=1";
        PreparedStatement prepareStatement=connection.prepareStatement(update);
        prepareStatement.setInt(1,0);
        prepareStatement.setInt(2,user.getId());
        prepareStatement.executeUpdate();
        connection.close();
    }
    @Override
    public void approveBorrower(Lending lending) throws ClassNotFoundException, SQLException 
    { 
        Connection connection=ConnectUtil.getConnection();
        String update="update lending_details set status=? where user_id=? ";
        PreparedStatement prepareStatement=connection.prepareStatement(update);
        prepareStatement.setString(1,lending.getStatus());
        prepareStatement.setInt(2,lending.getLenderId());
        prepareStatement.executeUpdate();
        connection.close();
    }
    
    public static List<User> retrieveDetail(User user) throws ClassNotFoundException, SQLException 
    {
        ArrayList<User> list=new ArrayList<>();
        Connection connection=ConnectUtil.getConnection();
        String select="select user_id,user_name,mail_id, user_password, user_type, phone_number, location from users where status=?";
        PreparedStatement prepareStatement=connection.prepareStatement(select);
        prepareStatement.setInt(1, 1);
        ResultSet resultSet=prepareStatement.executeQuery();
        while(resultSet.next())
        {
        	int id = resultSet.getInt(1);
            String name=resultSet.getString(2);
            String emailId=resultSet.getString(3);
            String password=resultSet.getString(4);
            String type = resultSet.getString(5);
            Long phoneNumber = resultSet.getLong(6);
            String location = resultSet.getString(7);
            
            user.setId(id);
            user.setName(name);
            user.setEmailId(emailId);
            user.setPassword(password);
            user.setType(type);
            user.setPhoneNumber(phoneNumber);
            user.setLocation(location);
            list.add(user);
        }
        connection.close();
        System.out.println(list);
        return list;
        
    }  
    
    //search book
    public static List<Book> retrieveDetail(Book book) throws ClassNotFoundException, SQLException 
    {
        List<Book> bookList = new ArrayList<>();
        Connection connection=ConnectUtil.getConnection();
        
        String select="select book_id, book_title, author_id, book_category, publication_year, isbn, book_summary, book_rating, book_reviews, book_cover,available_books FROM book_details where book_title=?";
        PreparedStatement prepareStatement=connection.prepareStatement(select);
        prepareStatement.setString(1, book.getBookTitle());
        ResultSet resultSet=prepareStatement.executeQuery();
        while(resultSet.next())
        {
        	
			/* Book book = new Book(); */
            book.setBookId(resultSet.getInt("book_id"));
            book.setBookTitle(resultSet.getString("book_title"));
            book.setAuthorId(resultSet.getInt("author_id"));
            book.setBookCategory(resultSet.getString("book_category"));
            book.setPublicationYear(resultSet.getInt("publication_year"));
            book.setIsbn(resultSet.getString("isbn"));
            book.setBookSummary(resultSet.getString("book_summary"));
            book.setBookRating(resultSet.getInt("book_rating"));
            book.setBookReviews(resultSet.getString("book_reviews"));
            book.setAvailableBook(resultSet.getInt("available_books"));
            book.setBookCover(resultSet.getBytes("book_cover"));
            bookList.add(book);

        }
        connection.close();
        System.out.println(bookList);
        return bookList; 
    }  
    
    public static List<Book> getAllBooks(String category) throws ClassNotFoundException, SQLException {
        List<Book> bookList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectUtil.getConnection();
            String sql;
            if (category == null || category.isEmpty()) {
                sql = "SELECT book_id, book_title, author_id, book_category, " +
                        "publication_year, isbn, book_summary, book_rating, " +
                        "book_reviews, book_cover,available_books FROM book_details";
            } else {
                sql = "SELECT book_id, book_title, author_id, book_category, " +
                        "publication_year, isbn, book_summary, book_rating, " +
                        "book_reviews, book_cover, available_books FROM book_details WHERE lower(book_category) = lower(?)";
            }
            
            preparedStatement = connection.prepareStatement(sql);
            
            if (category != null && !category.isEmpty()) {
                preparedStatement.setString(1, category.replace("@@", " "));
            }
            
            System.out.print("The statement"+preparedStatement);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getInt("book_id"));
                book.setBookTitle(resultSet.getString("book_title"));
                book.setAuthorId(resultSet.getInt("author_id"));
                book.setBookCategory(resultSet.getString("book_category"));
                book.setPublicationYear(resultSet.getInt("publication_year"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setBookSummary(resultSet.getString("book_summary"));
                book.setBookRating(resultSet.getInt("book_rating"));
                book.setBookReviews(resultSet.getString("book_reviews"));
                book.setAvailableBook(resultSet.getInt("available_books"));
                book.setBookCover(resultSet.getBytes("book_cover"));

                bookList.add(book);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return bookList;
    }
        
        public static List<User> getFindUsers(String email) throws ClassNotFoundException, SQLException {
            List<User> userList = new ArrayList<>();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                connection = ConnectUtil.getConnection();

                String sql;
                if (email == null || email.isEmpty()) {
                    sql = "SELECT user_id,user_name,mail_id, user_password, user_type, phone_number, location, status FROM users where user_type='user'";
                } else {
                    sql = "SELECT user_id,user_name,mail_id, user_password, user_type, phone_number, location, status FROM users WHERE mail_id =?";
                }
                
                preparedStatement = connection.prepareStatement(sql);
                
                System.out.print("The statement"+preparedStatement);
                
                if (email != null && !email.isEmpty()) {
                    preparedStatement.setString(1, email);
                }

                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                	System.out.print(resultSet);
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    user.setEmailId(resultSet.getString("mail_id"));
                    user.setName(resultSet.getString("user_name"));
                    user.setLocation(resultSet.getString("location"));
                    user.setGetStatus(resultSet.getInt("status"));
                    user.setPhoneNumber(resultSet.getLong("phone_number"));
                    user.setType(resultSet.getString("user_type"));
                  
                    userList.add(user);
                }
            } finally {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }

        return userList;
    }     
     
        public static List<User> getFindLibrarian(String email) throws ClassNotFoundException, SQLException {
            List<User> userList = new ArrayList<>();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                connection = ConnectUtil.getConnection();

                String sql;
                if (email == null || email.isEmpty()) {
                    sql = "SELECT user_id,user_name,mail_id, user_password, user_type, phone_number, location, status FROM users where user_type='librarian'";
                } else {
                    sql = "SELECT user_id,user_name,mail_id, user_password, user_type, phone_number, location, status FROM users WHERE mail_id =?";
                }
                
                preparedStatement = connection.prepareStatement(sql);
                
                System.out.print("The statement"+preparedStatement);
                
                if (email != null && !email.isEmpty()) {
                    preparedStatement.setString(1, email);
                }

                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                	System.out.print(resultSet);
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    user.setEmailId(resultSet.getString("mail_id"));
                    user.setName(resultSet.getString("user_name"));
                    user.setLocation(resultSet.getString("location"));
                    user.setGetStatus(resultSet.getInt("status"));
                    user.setPhoneNumber(resultSet.getLong("phone_number"));
                    user.setType(resultSet.getString("user_type"));
                  
                    userList.add(user);
                }
            } finally {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }

        return userList;
    }
    
    public static List<String> getAllCategory() throws ClassNotFoundException, SQLException {
        List<String> categoryList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectUtil.getConnection();
            String sql;
            sql = "SELECT distinct book_category FROM book_details";
            
            preparedStatement = connection.prepareStatement(sql);
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                 categoryList.add(resultSet.getString("book_category"));
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return categoryList;
    }	
}
