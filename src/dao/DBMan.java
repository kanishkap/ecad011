package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMan {
	
	
	static Connection con=null;
	static Statement st=null;
	static 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://au-cdbr-sl-syd-01.cleardb.net/ibmx_f9efba0e58cc669?user=b1d6fc7b3aade6&password=bf17f2b3");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static int insert(String sql) throws SQLException
	{
	
		
		PreparedStatement ps=con.prepareStatement(sql);
		int i=ps.executeUpdate();
		return i;
	}
	
	public static ResultSet select(String sql) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
		
	}
	

}
