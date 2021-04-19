package ola.com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnetionTest {

	public static Connection getConnection()
	{
		Connection con = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","java");
		System.out.println("Connected successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
