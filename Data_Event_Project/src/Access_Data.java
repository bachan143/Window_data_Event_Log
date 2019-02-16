import java.sql.*;
import java.util.*;
class Access_Data
{
	public static void main(String[] args)throws Exception
	{
		int eventid;
		Scanner sc=new Scanner(System.in);
		System.out.println("input the eventid"); 
		eventid=sc.nextInt();
		System.out.println("===================================");
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:dsn_csv");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from bachan.csv");
		boolean flag=false;
		
		while(rs.next())
		{
			int index = rs.getInt(4);
			//System.out.println(index);
			if(index == eventid)
			{
				flag=true;
				
				System.out.println("Detalis of eventid:");
				System.out.println("Level:"+rs.getString(1));
				System.out.println("Date and Time:"+rs.getString(2));
				System.out.println("Source:"+rs.getString(3));
				System.out.println("Event ID:"+index);
				System.out.println("Task Category:"+rs.getString(5));
				System.out.println("Description:"+rs.getString(6));
				System.out.println("=======================");
			}
			

		}
		if(flag==false)
			   System.out.println("event Id not found!");
		

		
	}
}