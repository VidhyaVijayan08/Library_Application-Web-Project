<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
</head>
<body>
    <h1>Shopping Cart</h1>
    <form action="AddToCartServlet" method="post">
        Selling ID: <input type="text" name="selling_id"><br>
        Quantity: <input type="text" name="quantity"><br>
        <input type="submit" value="Add to Cart">
    </form>
</body>
</html>