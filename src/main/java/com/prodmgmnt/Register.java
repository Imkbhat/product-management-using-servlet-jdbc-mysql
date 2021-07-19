package com.prodmgmnt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 14566777777779L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("userName");
		String p=request.getParameter("userPass");
		String e=request.getParameter("userEmail");
		String c=request.getParameter("userContact");
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management?useSSL=false", "root", "root");
		PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?,?)");
		ps.setInt(1, (int)Math.random());
		ps.setString(2,n);
		ps.setString(3,p);
		ps.setString(4,c);
		ps.setString(5,e);
		
		
		int i=ps.executeUpdate();
		if(i>0) {
		HttpSession session = request.getSession();
		session.setAttribute("userCreated",n);
		response.sendRedirect("login.jsp");
		}
			
		}catch (Exception e2) {System.out.println(e2);}
		
		out.close();
	}

}
