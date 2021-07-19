package com.prodmgmnt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1456677444445779L;
	private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String prodName=request.getParameter("prodName");
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management?useSSL=false", "root", "root");
		PreparedStatement ps=con.prepareStatement("DELETE FROM products WHERE product_name=?");
		ps.setString(1, prodName);
		
		int i=ps.executeUpdate();
		if(i>0) {
			HttpSession session = request.getSession();
			List<Map<String, String>> listOfProducts = loginDao.getAllProducts();
			session.setAttribute("products", listOfProducts);
			response.sendRedirect("products.jsp");
		}
			
		}catch (Exception e2) {System.out.println(e2);}
		
		out.close();
	}

}
