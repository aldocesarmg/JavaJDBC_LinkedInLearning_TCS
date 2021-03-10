package com.aldocesarmg;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection conexion = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conexion = DBUtil.getConnection(DBType.MYSQL);
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
