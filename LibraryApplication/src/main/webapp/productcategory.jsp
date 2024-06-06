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
 --%>	<h2>Products</h2>
 <form action="ViewServlet" method="post">
    <button type="submit" name="category" value="Folk Tale" style="border: none; background: none; padding: 0;">
        <div class="card">
            <div class="card-details">
                <h3>Folk Tale</h3>
            </div>
        </div>
    </button>
</form>

<form action="ViewServlet" method="post">
    <button type="submit" name="category" value="Fantasy" style="border: none; background: none; padding: 0;">
        <div class="card">
            <div class="card-details">
                <h3>Fantasy</h3>
            </div>
        </div>
    </button>
</form>

<!-- <!-- Similarly, add forms for Thriller and Horror categories -->
 
 <!-- <form action="ViewServlet" method="post">
    <button type="submit" name="category" value="Folk Tale" style="border: none; background: none; padding: 0;">
        <div class="card">
            <div class="card-details">
                <h3>Folk Tale</h3>
            </div>
        </div>
    </button>
</form>

<form action="ViewServlet" method="post">
    <button type="submit" name="category" value="Thriller" style="border: none; background: none; padding: 0;">
        <div class="card">
            <div class="card-details">
                <h3>Thriller</h3>
            </div>
        </div>
    </button>
</form> --> 

<form action="ViewServlet" method="post">
    <button type="submit" name="category" value="Thriller" style="border: none; background: none; padding: 0;">
        <div class="card">
            <div class="card-details">
                <h3>Folk Tale</h3>
            </div>
        </div>
    </button>
</form>

<form action="ViewServlet" method="post">
    <button type="submit" name="category" value="Horror" style="border: none; background: none; padding: 0;">
        <div class="card">
            <div class="card-details">
                <h3>Fantasy</h3>
            </div>
        </div>
    </button>
</form> 
 
	 <%-- <%--   <form action="ViewServlet" method="post">
	     <button type="submit" value="Folk Tale" style="border: none; background: none; padding: 0;">
		   <div class="card">
			<div class="card-details">
				<h3 value="folk">Folk Tale</h3>
				<%data.setAttribute("folk", "Folk Tale"); %> 
				<!-- You can add more details here -->
			</div>
			</div>
		</button>
		 </form>
	  	<form action="ViewServlet" method="post">
	    <button type="submit" style="border: none; background: none; padding: 0;">
		<div class="card">
			<div class="card-details">
				<h3>Fantasy</h3>
				 <%data.setAttribute("folk", "fantasy"); %> 
				<!-- You can add more details here -->
			</div>
		</div>
		</form>
		<form action="ViewServlet" method="post">
			<div class="card">
				<div class="card-details">
					<h3>Thriller</h3>
					<!-- You can add more details here -->
				</div>
			</div>
		</form>
		<form action="ViewServlet" method="post">
			<div class="card">
				<div class="card-details">
					<h3>Horror</h3>
					<!-- You can add more details here -->
				</div>
			</div>
		</form> --%> 
	  
</body>
</html>
