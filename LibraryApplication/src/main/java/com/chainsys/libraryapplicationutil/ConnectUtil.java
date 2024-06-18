package com.chainsys.libraryapplicationutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Connection connection = getConnection();
		}
		 
		public static Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/library","root","Welcome#78");
			return connection;
		}
}
