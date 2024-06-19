<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.*, java.io.*, java.util.Base64, com.chainsys.libraryapplicationdao.LibraryImpl, com.chainsys.libraryapplicationmodel.Book"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<style> 

/* h3{
	margin: 0px;
	font-size: 22px;
} */

h2{
	color:white;
	font-size: 40px;
}

body{
	text-align: center;
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

main{
	background-color: darkblue;
	padding: 5px;
}

.card-container{
	width: 40%;
    margin: 0 auto;
}

		li{
			display: inline-block;
		    list-style: none;
		    padding: 0px 11px;
		    font-size: 22px;
	    	font-weight: 800;	
		}
		
		h1{
		text-align: center;
	    display: inline-block;
	    vertical-align: middle;
	    padding: 0px 91px;
		}
		
		button{
			cursor: pointer;
		    background: none;
		    border: none;
		    font-size: 19px;
		    font-weight: 600;
		}
		
		.nav-ul{
			display:inline-block;
			vertical-align: middle;
		}
		
		.logo-container{
			display: inline-block;
			vertical-align: middle;
		}
		
		.logo-img{
			height: 135px;
		}
		
		header{
			height: 135px;
		}

</style>
</head>
<body>

<header class="header-container">
		<div class="logo-container">
			<a href="index.html" class="logo-atag"><img src="logo.jpg"
				alt="Library Logo" class="logo-img"></a>
		</div>
		<h1
			style="text-align: center; width: 40%; display: inline-block; padding: 0 91px;">Library
			Application</h1>
		<nav class="nav" style="display: inline-block;">
			<ul class="nav-ul">
				<li class="nav-ul-li"><a href="productCategory.jsp"
					style="text-decoration: none; color: black">Books</a></li>
				<li class="nav-ul-li"><a href="about.html"
					style="text-decoration: none; color: black">About Us</a></li>


				<li class="nav-ul-li"><form action="LogoutServlet"
						method="post">
						<button>Logout</button>
					</form></li>

			</ul>
		</nav>
	</header>

<main>
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
	  
	 <div class="card-container">
		 <div class="card">
	            <div class="card-details">
	               <a href="addBook.jsp" style="text-decoration: none; color: black;">Add Book</a>
	            </div>
	     </div>
	        
	     <div class="card">
	          <div class="card-details">
	             <a href="view.html" style="text-decoration: none; color: black;">EBook</a>
	          </div>
	     </div>
	 </div>
</main>
</body>
</html>
