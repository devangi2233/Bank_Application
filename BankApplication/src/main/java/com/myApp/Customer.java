package com.myApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("customer.jsp"); // Redirect to the customer management JSP page
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                response.getWriter().println("Invalid action.");
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String accNo = request.getParameter("accNo");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String balance = request.getParameter("balance");
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Load the JDBC driver
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "")) {
            	String sql = "INSERT INTO cust (name, accNo, DOB, gender, address, email, phone, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                	preparedStatement.setString(1, name);
                    preparedStatement.setString(2, accNo);
                    preparedStatement.setString(3, dob);
                    preparedStatement.setString(4, gender);
                    preparedStatement.setString(5, address);
                    preparedStatement.setString(6, email);
                    preparedStatement.setString(7, phone);
                    preparedStatement.setString(8, balance);
                    preparedStatement.executeUpdate();
                    response.getWriter().println("Registration successful.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error during registration: " + e);
        }
    }

        
 

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String accNo = request.getParameter("accNo");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String balance = request.getParameter("balance");

        // Database connection and update logic
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Load the JDBC driver
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "")) {
            	String sql = "UPDATE cust SET name=?, dob=?, gender=?, address=?, email=?, phone=?, balance=? WHERE accNo=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                	preparedStatement.setString(1, name);
                    preparedStatement.setString(2, accNo);
                    preparedStatement.setString(3, dob);
                    preparedStatement.setString(4, gender);
                    preparedStatement.setString(5, address);
                    preparedStatement.setString(6, email);
                    preparedStatement.setString(7, phone);
                    preparedStatement.setString(8, balance);

                    response.getWriter().println("Update successful.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error during registration: " + e);
        }
    }


    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String accNo = request.getParameter("accNo");

    	 try {
             Class.forName("com.mysql.jdbc.Driver"); // Load the JDBC driver
             try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "")) {
            	 String sql = "DELETE FROM cust WHERE accNo=?";
                 try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                	 preparedStatement.setString(1, accNo);

                     response.getWriter().println("Delete successful.");
                 }
             }
         } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
             response.getWriter().println("Error during registration: " + e);
         }
     }

        

}
