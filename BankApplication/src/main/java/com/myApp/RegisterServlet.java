package com.myApp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        response.sendRedirect("register.jsp"); // Redirect to the registration JSP page
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String contact = request.getParameter("contact");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String agreeTerms = request.getParameter("agreeTerms");

        if (!password.equals(confirmPassword)) {
            response.getWriter().println("Password and Confirm Password must be the same.");
            return;
        }

 
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Load the JDBC driver
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "")) {
                String sql = "INSERT INTO register (fname, lname, contact, email, password) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, fname);
                    preparedStatement.setString(2, lname);
                    preparedStatement.setString(3, contact);
                    preparedStatement.setString(4, email);
                    preparedStatement.setString(5, password);
                    preparedStatement.executeUpdate();
//                    response.getWriter().println("Registration successful.");
                    
                    response.sendRedirect("login.jsp");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error during registration: " + e);
        }
    }

}
