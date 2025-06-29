package vistora.servlet;

import java.sql.*;

public class JdbcCnonnection {
	public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/navya", "root", "12345");
    }

}



