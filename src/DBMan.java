import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBMan {
	
	
	public static String url="jdbc:mysql://au-cdbr-sl-syd-01.cleardb.net/ibmx_aa1c3a32807ecdd";
	public static String uname="bedf48af683582";
	public static String upass="b764883b";
	
	
	private static Connection cn;
	private static Statement st;
	
	static{
		try
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			cn=DriverManager.getConnection(url,uname,upass);
			st=cn.createStatement();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	public static int InsertRecord(String roll,String stuname,String branch,String category,String message)
	{
	
		String sql="insert into feedback(roll,stuname,branch,category,message)"
			+"values('"+roll+"','"+stuname+"','"+branch+"','"+category+"','"+message+"')";
	
	try
	{
		return st.executeUpdate(sql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return -1;
		
	}
	}
	
	public static ResultSet getFeedbacks()throws Exception
	{
		return st.executeQuery("Select * from feedback order by fid desc limit 5");
	}
	
	
	
	

}
