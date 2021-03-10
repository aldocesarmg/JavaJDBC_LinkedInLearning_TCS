package com.aldocesarmg;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        try (   // Toda la información contenida dentro de estos paréntesis se cerrará automáticamente al terminar
                // esta sentencia de try catch
                Connection conexion = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM states");
                ) {

            System.out.println("Connected");

            rs.last();
            System.out.println("Number of rows: " + rs.getRow());

        } catch (SQLException throwables) {
            System.err.println(throwables);
        }
    }
}
