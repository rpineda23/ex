package com.ex.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {

	public static Connection getConnection() {
		Properties props = new Properties();
		FileInputStream fis = null;
		Connection con = null;
		
		//String DB_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
		//String DB_USERNAME = "admin";
		//String DB_PASSWORD = "R3zz1$#1";
		//String DB_URL = "jdbc:oracle:thin:@database-1.cn73xs2qgjl5.us-east-2.rds.amazonaws.com:1521:ORCL";
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);

			// load the Driver Class
			//System.out.println("before connection.");
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			//System.out.println("after connection.");

			// create the connection now
			con = DriverManager.getConnection(props.getProperty("DB_URL"),
					props.getProperty("DB_USERNAME"),
					props.getProperty("DB_PASSWORD"));
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}