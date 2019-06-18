package com.CarDealership;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static String username;
	private static String url;
	private static String password;
	private static final String PROPERTIES_FILE = "src/main/java/com/CarDealership/Database.Properties";
	private static ConnectionFactory cf;

	public static Connection getConnection() {

		if (cf == null) {
			cf = new ConnectionFactory();
		}
		return cf.createConnection();
	}
	
	private ConnectionFactory() {
		//private constructor makes this a singleton
		Properties prop = new Properties();
		try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE);){
			prop.load(fis);
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		Connection conn = null;
		
		try {
			System.out.print("Network Established!");
			System.out.println();
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Faild to make DB Connection");
			e.printStackTrace();
		}
		return conn;
	}
}
