<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*, java.util.Base64, com.chainsys.libraryapplicationdao.LibraryImpl, com.chainsys.libraryapplicationmodel.Book" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head> 
    <title>View Products</title>
    <style>
    
    body{
    	background-color: darkblue;
    }
    h2{
    	color: white;
    	text-align:center;
    }
form {
	display:inline-block;
}

.card {
	background-color: white;
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 10px;
	margin: 10px;
	width: 200px;
	float: left;
	cursor: pointer;
	transition: transform 0.2s;
}

.card img {
	max-width: 100%;
	height: 300px;
	object-fit: cover;
}

.card:hover {
	transform: scale(1.05);
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>
    <h2>Products</h2>
    <% 
        try {
            List<Book> bookList = LibraryImpl.getAllBooks(null);
            
            for (Book book : bookList) {
                    byte[] imageBytes = book.getBookCover(); // Assuming you have a method to retrieve book cover as byte array
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
    %>
                    <form action="ViewServlet" method="post">
                    <input type="hidden" name="category" value="<%= book.getBookCategory() %>">
                        <button type="submit" style="border: none; background: none; padding: 0;">
                            <div class="card">
                                <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Book Cover">
                                <div class="card-details">
                                    <h3><%= book.getBookTitle() %></h3>
                                    <p>Category: <%= book.getBookCategory()%></p>
                                </div>
                            </div>
                        </button>
                    </form>
    <%
                }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    %>
</body>
</html>
