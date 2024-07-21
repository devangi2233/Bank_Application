package com.myApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Database connection
        try (Connection connection = createConnection()) {
            String sql = "SELECT * FROM register WHERE email = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // Login successful, redirect to main page
//                    response.sendRedirect("main.jsp");
                	response.getWriter().println("Login successful.");
                } else {
                    // Invalid login, redirect back to login page with error message
                    response.sendRedirect("login.jsp?error=invalid");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=database");
        }
    }

    private Connection createConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
