package DAO;

import java.sql.*;

public class Database {
    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone=SERVER";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String userName = "sqlUser";
    private static String password = "Passw0rd!";
    public static Connection connection;  // Connection Interface

    public static void openConnection() {
        try {
            Class.forName(driver); // Load the MySQL driver
            connection = DriverManager.getConnection(jdbcUrl, userName, password); // Establish the connection
            System.out.println("Connection successful!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static boolean validateUserCredentials(String username, String password) {
        String query = "SELECT * FROM users WHERE User_Name = ? AND Password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();  // If a result exists, the credentials are valid
        } catch (SQLException e) {
            System.out.println("Error during login validation: " + e.getMessage());
            return false;
        }
    }
//adding various methods which will execute SQL commands, interacting with the customers table
    public static boolean addCustomer(String name, String address, String postalCode, String phone, int divisionId) {
        String query = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Division_ID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, postalCode);
            stmt.setString(4, phone);
            stmt.setInt(5, divisionId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error adding customer: " + e.getMessage());
            return false;
        }
    }




}
