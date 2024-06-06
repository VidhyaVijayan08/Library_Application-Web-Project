<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
<style>
body {
	background-image: url("register.jpg");
	background-size: cover;
	background-repeat: no-repeat;
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
}

h2 {
    text-align: center;
}

form {
    max-width: 500px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

form input[type="text"],
form textarea,
form input[type="file"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

form textarea {
    height: 100px;
    resize: none;
}

form input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

form input[type="submit"]:hover {
    background-color: #0056b3;
}

</style>
</head>
<body>
    <h2>Add Book</h2>
    <form action="AdminServlet" method="post" enctype="multipart/form-data">
        Book ID: <input type="text" name="bookId" required><br>
        Book Title: <input type="text" name="bookTitle" required><br>
        Author ID: <input type="text" name="authorId" required><br>
        Book Category: <input type="text" name="bookCategory" required><br>
        Publication Year: <input type="text" name="publicationYear"  pattern="\d{4}" title="Enter a valid year (4 digits)" required><br>
        ISBN: <input type="text" name="isbn" pattern="\d{10}|\d{13}" title="Enter a 10 or 13 digit ISBN number" required><br>
        Book Summary: <textarea name="bookSummary" required></textarea><br>
        Book Rating: <input type="text" name="bookRating"  pattern="[1-5]" title="Enter a rating between 1 and 5" required><br>
        Book Review: <textarea name="bookReview" required></textarea><br>
        Book In Stock: <input type="text" name="bookInStock"  min="0" required><br>
        Available book: <input type="text" name="availableBook"  min="0" required><br>
        Book Cover: <input type="file" name="filePart" accept="image/*" required><br>
        <input type="submit" value="Add Book">
    </form>

</body>
</html>
