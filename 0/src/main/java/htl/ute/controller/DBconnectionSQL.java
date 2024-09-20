package htl.ute.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import htl.ute.controller.DBconnectionSQL;

public class DBconnectionSQL {
	private static String DB_URL="jdbc:mysql://localhost:3306/ltweb01";
	private static String user_name="root";
	private static String pass="lamhocUTE2024.";
	private static Connection con;
	public static Connection getConn() throws IOException{
		con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = (Connection) DriverManager.getConnection(DB_URL, user_name, pass);
		} catch (SQLException ex) {
			Logger.getLogger(DBconnectionSQL.class.getName()).log(Level.SEVERE,null, ex);
		}
		return (con);
	}
	public static void main(String[] args){
		try {
			Connection c = getConn();
			if(c== null) {
				System.out.println("Something went wrong");
			} else {
				System.out.println("Success");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}

