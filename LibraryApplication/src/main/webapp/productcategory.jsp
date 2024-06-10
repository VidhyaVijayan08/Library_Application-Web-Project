<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.*, java.io.*, java.util.Base64, com.chainsys.libraryapplicationdao.LibraryImpl, com.chainsys.libraryapplicationmodel.Book"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<style> 
.card {
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
<%-- <% HttpSession data = request.getSession();%>
 --%>	<h2>Category</h2>
  <% 
        try {
            List<String> categoryList = LibraryImpl.getAllCategory();
            for (String category : categoryList) {
//            	System.out.print("category in product category page"+category);
//            	category=category.replace(" ","");
  %>
   <form action="ViewServlet" method="post">
    <button type="submit" name="category" value=<%=category.replace(" ","@@")%> style="border: none; background: none; padding: 0;">
        <div class="card">
            <div class="card-details">
                <h3><%=category%></h3>
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
