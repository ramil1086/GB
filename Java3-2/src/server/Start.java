package server;

import java.sql.*;


public class Start {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
//        new Server();

                connect();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM clientsTable");
            while (rs.next()) {
                String loginFromBase = rs.getString("login");
                String passwordFromBase = rs.getString("password");
                System.out.println(loginFromBase + " " + passwordFromBase);
                }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }
    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:clientsBase.db");
            System.out.println("Подключились к БД");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
