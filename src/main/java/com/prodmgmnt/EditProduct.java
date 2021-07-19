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

@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1456677444666445779L;
	private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String prodName=request.getParameter("prodName");
		String prodId = request.getParameter("prodId");
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management?useSSL=false", "root", "root");
		PreparedStatement ps=con.prepareStatement("update products set product_name=? WHERE product_id=?");
		ps.setString(1, prodName);
		ps.setInt(2, Integer.parseInt(prodId));
		
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
