package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import DTO.LoaisachDTO;

public class DBConnect {
	public  static String DB_URL = "jdbc:mysql://localhost:3306/qltv?useUnicode=true&characterEncoding=utf-8";
	public static String USER_NAME = "root";
	public static String PASSWORD = "";
	
	public static Connection conn = null;
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			// System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
	public DBConnect() {
		
		   Properties pro = new Properties();
	        pro.put("user",USER_NAME );
	        pro.put("password", PASSWORD);
	        try {
	            com.mysql.jdbc.Driver driver = new Driver();
	            conn = driver.connect(DB_URL, pro);
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Không thể kết nối tới csdl");
	            System.exit(0);
	        }

	}
	

	
}
