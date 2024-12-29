package com.example.demo;

import jakarta.servlet.ServletContext;

import java.sql.*;

public class JDBConnect {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    public JDBConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
            String id = "scott";
            String pwd = "tiger";
            conn = DriverManager.getConnection(url, id, pwd);
            System.out.println("DB connection success(default constructor)");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("DB connection fail(default constructor)" + e.getMessage());
        }
    }

    public JDBConnect(ServletContext application) {
        try {
            String driver = application.getInitParameter("MySQLDriver");
            Class.forName(driver);
            String url = application.getInitParameter("MySQLUrl");
            String id = application.getInitParameter("MySQLId");
            String pwd = application.getInitParameter("MySQLPwd");
            conn = DriverManager.getConnection(url, id, pwd);
            System.out.println("DB connection success(parameter constructor)");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("DB connection fail(parameter constructor): " + e.getMessage());
        }
    }

    public void close() {
        try {
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
            System.out.println("JDBC resource release");
        } catch (SQLException e) {
            System.out.println("JDBC resource release fail" + e.getMessage());
        }
    }

}
