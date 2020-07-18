package com.rx.tushu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    private static Connection connection;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            String username="root";
            String pwd="123456";
            String url="jdbc:mysql://localhost:3306/bookInfo";
           connection = DriverManager.getConnection(url,username,pwd);
           return connection;
    }
       public static void close(Connection connection) throws SQLException {
            if (connection!=null){
                connection.close();
            }
        }
}
