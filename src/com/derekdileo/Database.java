package com.derekdileo;

import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionCreator;

import java.sql.Connection;
import java.sql.DriverManager;

/** The Database class will be home to all methods which
 *  pertain to the local MySQL database for this project.
 *  @author derekdileo */
public class Database {

    // Declare shared Connection field
    protected static Connection conn;

    /** Method establishes a connection with local MySQL database
     *  @return returns a database Connection to the caller
     *  @throws Exception */
    public static Connection getConn() {

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/todo_app";
            String username = "root";
            String password = "password";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            return conn;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }



}
