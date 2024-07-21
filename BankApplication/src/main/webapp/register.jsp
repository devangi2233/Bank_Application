<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        #root {
            text-align: center;
            padding: 20px;
            background-color: #007bff;
            color: #ffffff;
        }
        form {
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 500px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="checkbox"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
            font-size: 16px;
        }
        input[type="checkbox"] {
            width: auto;
            margin-right: 5px;
        }
        button[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
            font-size: 16px;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: #ff0000;
            margin-top: 10px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div id="root">
        <h1>Welcome to Bank of Mumbai</h1>
    </div>
    <div>
        <h2>Register Here</h2>
        <form action="RegisterServlet" method="post">
            <label>First Name:</label>
            <input type="text" name="fname" required><br>
            <label>Last Name:</label>
            <input type="text" name="lname" required><br>
            <label>Contact:</label>
            <input type="text" name="contact" required><br>
            <label>Email:</label>
            <input type="email" name="email" required><br>
            <label>Password:</label>
            <input type="password" name="password" required><br>
            <label>Confirm Password:</label>
            <input type="password" name="confirmPassword" required><br>
            <input type="checkbox" name="agreeTerms" required>
            <label>I Agree The Terms And Conditions</label><br>
            <button type="submit">Register</button>
        </form>
        <div class="error-message">
            <!-- Display error messages here -->
        </div>
    </div>
</body>
</html>
