package com.aldocesarmg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";
    private static final String H_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";

    public static Connection getConnection(DBType dbType) throws SQLException {
        switch (dbType) {
            case MYSQL:     // es necesario incluir el driver en de las dependencias del proyecto
                return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
            case HSQLDB:    // es necesario incluir el driver en las dependencias del proyecto, añadir los archivos .properties y .script y modificar el script
                return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
            default:
                return null;
        }
    }

}
