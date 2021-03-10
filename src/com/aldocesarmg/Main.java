package com.aldocesarmg;

import com.aldocesarmg.db.tables.Tours;

import java.sql.*;

public class Main {

    public static final String ConsultaSQL = "SELECT tourId, tourName, price FROM tours WHERE price <= ?";

    public static void main(String[] args) throws SQLException {

        ResultSet rs2 = null;

        try (   // Toda la información contenida dentro de estos paréntesis se cerrará automáticamente al terminar
                // esta sentencia de try catch
                Connection conexion = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM tours LIMIT 5");
                ) {

            System.out.println("Connected");

            Tours.displayData(rs);

            //rs.last();
            //System.out.println("Number of rows: " + rs.getRow());

        } catch (SQLException throwables) {
            System.err.println(throwables);
        }

        //NUEVA CONSULTA CON PARÁMETROS
        System.out.println("\nNueva consulta con parámetros\n");

        try (
                Connection conexion = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt2 = conexion.prepareStatement(ConsultaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ) {

            stmt2.setDouble(1, 500);
            rs2 = stmt2.executeQuery();
            Tours.displayData(rs2);

        } catch (SQLException throwables) {

        } finally {
            if (rs2 != null) rs2.close();
        }
    }
}
