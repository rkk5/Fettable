import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class Fetable {

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		
		String url="jdbc:oracle:thin:@localhost:1521:xe ";
        String un="system";
        String pw="9985";
        ResultSet res;
        Connection con = null  ;
  
        PreparedStatement pstmt ;
        
        
        try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("driver loaded sucessfully");
		
		 try {
			con=DriverManager.getConnection(url,un,pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("connection established");
		
		String s="SELECT * FROM STUDENTMARKS WHERE USN=?";
        
		pstmt=con.prepareStatement(s);
		
		System.out.println(pstmt);
		
		System.out.println("enter the usn");
		
		Scanner scan=new Scanner(System.in);
		
		String temp=scan.next();
		
		pstmt.setString(1,temp);

		res=pstmt.executeQuery();
		
		while(res.next()==true)
		{
			String name=res.getString("NAME");
			
			int m1=res.getInt("m1");
			int m2=res.getInt("m2");
			int m3=res.getInt("m3");
			String usn=res.getString("USN");
		//	String usn=res.getString("USN");
			System.out.println(name+" "+usn+"  "+m1+" "+m2+" "+m3);	
			
		}
		
		
		
		
		
		
		
		
				
				
		
		
		

	}

}
