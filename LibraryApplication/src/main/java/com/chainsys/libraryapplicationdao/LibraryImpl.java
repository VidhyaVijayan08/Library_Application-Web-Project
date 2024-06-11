package com.chainsys.libraryapplicationdao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chainsys.libraryapplicationmodel.Book;
import com.chainsys.libraryapplicationmodel.Lending;
import com.chainsys.libraryapplicationmodel.User;
import com.chainsys.libraryapplicationutil.ConnectUtil;
public class LibraryImpl implements LibraryDAO{
 
	public void saveLibrary(User user) throws ClassNotFoundException, SQLException {
		 Connection con = ConnectUtil.getConnection();
	        String add = "insert into users(user_name,mail_id, user_password, user_type, phone_number, location,status,approval)values(?,?,?,?,?,?,?,?)";
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
	            ps.setString(8, "Not Approval");;
	            System.out.println("Setting Student name : " + user.getName());
	            int rows = ps.executeUpdate();
	            System.out.println("In Add movie Servlet.." + rows);
	}
	
	public void saveRequest(Lending lending) throws ClassNotFoundException, SQLException{
		Connection con = ConnectUtil.getConnection();
		String add ="insert into lending_details(book_id, lender_id, borrower_id,borrower_date,due_date,status,fine) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(add);
		lending.setBookId(lending.getBookId());
		System.out.println("Getting Book Id :" + lending.getBookId());
	    ps.setInt(1, lending.getBookId());
        ps.setInt(2, lending.getLenderId());
        ps.setInt(3, lending.getBorrowerId());
        ps.setString(4, lending.getBorrowerDate());
        ps.setString(5, lending.getDueDate());
        ps.setString(6, "Pending");
        ps.setDouble(7, 0.0);
        System.out.println("Setting Lender ID : " + lending.getLenderId());
        int rows = ps.executeUpdate();
        System.out.println("In Add movie Servlet.." + rows);
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
                        "book_reviews, book_cover,available_books FROM book_details";
            } else {
                sql = "SELECT book_id, book_title, author_id, book_category, " +
                        "publication_year, isbn, book_summary, book_rating, " +
                        "book_reviews, book_cover, available_books FROM book_details WHERE lower(book_category) = lower(?)";
            }
            
            // Create PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            
            // Set category parameter if it's not null or empty
            if (category != null && !category.isEmpty()) {
                preparedStatement.setString(1, category.replace("@@", " "));
            }
            
            System.out.print("The statement"+preparedStatement);

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
                book.setAvailableBook(resultSet.getInt("available_books"));
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
        
        public static List<User> getfindusers(String email) throws ClassNotFoundException, SQLException {
            List<User> userList = new ArrayList<>();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                // Get connection
                connection = ConnectUtil.getConnection();

                // SQL query to retrieve all books
                String sql;
                if (email == null || email.isEmpty()) {
                    sql = "SELECT user_id,user_name,mail_id, user_password, user_type, phone_number, location, status FROM users";
                } else {
                    sql = "SELECT user_id,user_name,mail_id, user_password, user_type, phone_number, location, status FROM users WHERE mail_id =?";
                }
                
                // Create PreparedStatement
                preparedStatement = connection.prepareStatement(sql);
                
                System.out.print("The statement"+preparedStatement);
                
                if (email != null && !email.isEmpty()) {
                    preparedStatement.setString(1, email);
                }

                // Execute query
                resultSet = preparedStatement.executeQuery();

                // Process ResultSet
                while (resultSet.next()) {
                	System.out.print(resultSet);
                    // Create User object and set its properties
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    user.setEmailId(resultSet.getString("mail_id"));
                    user.setName(resultSet.getString("user_name"));
                    user.setLocation(resultSet.getString("location"));
                    user.setGetStatus(resultSet.getInt("status"));
                    user.setPhoneNumber(resultSet.getLong("phone_number"));
                    user.setType(resultSet.getString("user_type"));
                  
                    // Add User object to the list
                    userList.add(user);
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

        return userList;
    }
    
    public static List<String> getAllCategory() throws ClassNotFoundException, SQLException {
        List<String> categoryList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Get connection
            connection = ConnectUtil.getConnection();

            // SQL query to retrieve all books
            String sql;
            sql = "SELECT distinct book_category FROM book_details";
            
            // Create PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            
            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Process ResultSet
            while (resultSet.next()) {

                // Add Category object to the list
                 categoryList.add(resultSet.getString("book_category"));
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

        return categoryList;
    }

    public static List<Map<String,Object>> getAllLendingInformation() throws ClassNotFoundException, SQLException {
    	List<Map<String,Object>> userList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Get connection
            connection = ConnectUtil.getConnection();

            // SQL query to retrieve all books
            String sql = "SELECT ld.lending_id, ld.book_id, bd.book_title, bd.available_books, ld.lender_id, u.mail_id,\r\n"
            		+ "ld.due_date, ld.status, ld.reservation_date\r\n"
            		+ "FROM library.lending_details ld\r\n"
            		+ "inner join book_details bd on bd.book_id=ld.book_id\r\n"
            		+ "left join users u on u.user_id=ld.lender_id";
            
            // Create PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            
            System.out.print("The statement"+preparedStatement);
            
            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Process ResultSet
            while (resultSet.next()) {
            	System.out.print(resultSet);
                // Create User object and set its properties
                Map<String, Object> requestedBook = new HashMap<String,Object>();

                requestedBook.put("lending_id", resultSet.getInt("lending_id"));
                requestedBook.put("book_id", resultSet.getInt("book_id"));
                requestedBook.put("book_title", resultSet.getString("book_title"));
                requestedBook.put("available_books", resultSet.getInt("available_books"));
                requestedBook.put("lender_id", resultSet.getInt("lender_id"));
                requestedBook.put("mail_id", resultSet.getString("mail_id"));
                requestedBook.put("due_date", resultSet.getString("due_date"));
                requestedBook.put("status", resultSet.getString("status"));
                requestedBook.put("reservation_date", resultSet.getString("reservation_date"));
              
                // Add User object to the list
                System.out.print("requestedBook : "+requestedBook);
                userList.add(requestedBook);
                System.out.print("userList : "+userList);
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

    return userList;
}
	
}
