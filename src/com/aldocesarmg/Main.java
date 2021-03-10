package com.aldocesarmg;

import java.sql.*;

public class Main {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";

    public static void main(String[] args) throws SQLException {
        Connection conexion = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conexion = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");

            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM states");

            rs.last();
            System.out.println("Number of rows: " + rs.getRow());

        } catch (SQLException throwables) {
            System.err.println(throwables);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
}
