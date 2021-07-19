package registeruser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {

	public static void main(String[] args) throws Exception {
		
		String n="Kiran";
		String p="Pass";
		String e="kbs71189";
		String c="983635335353";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management?useSSL=false", "root", "root");
		PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?,?)");
		ps.setInt(1, (int)(Math.random()));
		ps.setString(2,n);
		ps.setString(3,p);
		ps.setString(4,c);
		ps.setString(5,e);
		
		
		int i=ps.executeUpdate();
		if(i>0)
		System.out.print("You are successfully registered...");
	}
}
