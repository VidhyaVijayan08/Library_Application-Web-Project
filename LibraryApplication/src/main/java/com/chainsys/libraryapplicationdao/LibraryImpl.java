package com.chainsys.libraryapplicationdao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.libraryapplicationmodel.Book;
import com.chainsys.libraryapplicationmodel.User;
import com.chainsys.libraryapplicationutil.ConnectUtil;
import com.mysql.cj.jdbc.Blob;
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
	
	public static String checkPassword(String emailId) throws ClassNotFoundException, SQLException {
		String password=null;
		Connection connection = ConnectUtil.getConnection();
		String select = "select user_password from users where mail_id=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1,emailId);
    	ResultSet resultSet = prepareStatement.executeQuery(); 
    	while (resultSet.next()) {
            password= resultSet.getString(1);
    	}
        System.out.println(resultSet+" retrieved");		
        return password;
	}
	
	public void deleteServlet(User user) throws ClassNotFoundException, SQLException {
		Connection con = ConnectUtil.getConnection();
		String save="delete from  users where user_name=?";
        PreparedStatement prepareStatement = con.prepareStatement(save);
        prepareStatement.setString(1, user.getName());
        int rows = prepareStatement.executeUpdate();
    	System.out.println(rows + " deleted");
	}
	
	public static List<User> retrieveDetails() throws ClassNotFoundException, SQLException 
    {
        ArrayList<User> list=new ArrayList<>();
        Connection connection=ConnectUtil.getConnection();
        String select="select user_name,mail_id, user_password, user_type, phone_number, location from users";
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
	
	public static List<User> searchServlet(User user) throws ClassNotFoundException, SQLException {
        ArrayList<User> list=new ArrayList<>();
	  	Connection connection = ConnectUtil.getConnection();
        System.out.println(connection);
        String save="SELECT  user_name,mail_id, user_password , user_type, phone_number, location FROM users where user_name=?";
        PreparedStatement prepareStatement = connection.prepareStatement(save);
        prepareStatement.setString(1, user.getName());
        Statement stmt = connection.createStatement();
    	ResultSet rows = prepareStatement.executeQuery(); 
    	while (rows.next()) {
    		
    		
    		 String name=rows.getString(1);
             String emailId=rows.getString(2);
             String password=rows.getString(3);
             String type = rows.getString(4);
             Long phoneNumber = rows.getLong(5);
             String location = rows.getString(6);
//            System.out.println("Retrieved Data");
//            System.out.println("__________________________________________________________________________________");
//            System.out.println("Name : " + name + "\t\t Email : " + mailId  + "\t\t PhoneNumber : " + phoneNo);
//            System.out.println("__________________________________________________________________________________");
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
	
    public void removeUser(User user) throws ClassNotFoundException, SQLException 
    {
        Connection connection=ConnectUtil.getConnection();
        String update="update users set status=? where user_id=?";
        PreparedStatement prepareStatement=connection.prepareStatement(update);
        prepareStatement.setInt(1,0);
        prepareStatement.setInt(2,user.getId());
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
    
    
    public static List<Book> getAllBooks(String category) throws ClassNotFoundException, SQLException {
        List<Book> bookList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Get connection
            connection = ConnectUtil.getConnection();

            // SQL query to retrieve all books
            String sql;
            if (category == null || category.isEmpty()) {
                sql = "SELECT book_id, book_title, author_id, book_category, " +
                        "publication_year, isbn, book_summary, book_rating, " +
                        "book_reviews, book_cover FROM book_details";
            } else {
                sql = "SELECT book_id, book_title, author_id, book_category, " +
                        "publication_year, isbn, book_summary, book_rating, " +
                        "book_reviews, book_cover FROM book_details WHERE book_category = ?";
            }

            // Create PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            
            // Set category parameter if it's not null or empty
            if (category != null && !category.isEmpty()) {
                preparedStatement.setString(1, category);
            }

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Process ResultSet
            while (resultSet.next()) {
                // Create Book object and set its properties
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
                // Assuming book_cover is stored as byte array in the database
                book.setBookCover(resultSet.getBytes("book_cover"));

                // Add Book object to the list
                bookList.add(book);
            }
        } finally {
            // Close ResultSet, PreparedStatement, and Connection
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

	
	
}
