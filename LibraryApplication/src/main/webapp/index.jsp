<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.chainsys.libraryapplicationmodel.User" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
	background-image: url("backgrounds.webp");
	background-repeat: no-repeat;
	background-size: cover;
}
    table {
        border-collapse: collapse;
        width: 73%;
        margin-top: 200px;
        margin-left: 179px;
    }

    td {
        border: 2px solid #ddd;
        padding: 8px;
        margin-top: 500px;
    }
	
	.search-button{
	margin : 20px 0px;
	}
	
	.button-container{
	position: absolute;
    top: 19%;
    right: 14%;
	}
</style>
</head>
<body>

<table>
<tr>
    <td>Name</td>
    <td>Email</td>
    <td>Password</td>
    <td>Type</td>
    <td>PhoneNumber</td>
    <td>Location</td>
    <td colspan="2">Update</td>
    
</tr>
<% 
ArrayList<User> user =(ArrayList<User>)request.getAttribute("list1");
if (user != null && !user.isEmpty()) {
    for (User obj : user) {
%>
<tr>
   <td><%= obj.getName() %></td>
    <td><%= obj.getEmailId() %></td>
    <td><%= obj.getPassword() %></td>
    <td><%= obj.getType() %></td>
    <td><%= obj.getPhoneNumber() %></td>
	<td><%= obj.getLocation() %></td>
    <td>
       <form action="DeleteServlet" method="get">
            <input type="hidden" class="delete-button" value=<%=obj.getName()%> name="Name">
            <input type="submit" class="delete-button" value="Delete" name="action">
        </form>
    </td>
    	
    <td>
    <button><a href="edit.html" style="text-decoration:none; color:black;">Edit</a> </button>
    
    </td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="6">No users found</td>
</tr>
<%
}
%>
</table>
<div class="button-container">
<form action="SearchServlet" method="get">         
 		<input type="text" name="Name" id="Search" placeholder="Search ">
 	    <input type="submit" class="search-button" value="search" name="action">
	<button class="search-button"><a href="register.html" class="add-user-link" style="text-decoration:none; color:black;">Add User</a></button>
</form>
<button><a href="LogoutSessions" style="text-decoration:none; color:black">Logout</a></button>
</div>
</body>
</html>