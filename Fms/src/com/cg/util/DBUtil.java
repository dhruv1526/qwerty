package com.cg.util;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class DBUtil {
	
	public static Connection getConnection() {
		
//		try {		

//		Properties props=new Properties();
//		
//FileInputStream fis;
//
//	fis = new FileInputStream("khan.properties");
//
//		
//		props.load(fis);
//		String uname =props.getProperty("username");//key name
//		String pwd =	props.getProperty("password");//key name
//		String url =props.getProperty("url");//key name
//		
		Connection con = null;
		try {
			con = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/feedback","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(con);
		
		return con;
}
}
