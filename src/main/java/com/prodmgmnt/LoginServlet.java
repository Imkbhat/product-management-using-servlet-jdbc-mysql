package com.prodmgmnt;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 102831973239L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("userName");
        String password = request.getParameter("userPass");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
            if (loginDao.validate(loginBean)) {
            	
            	//get all products
            	List<Map<String, String>> listOfProducts = loginDao.getAllProducts();
            	
            	
                HttpSession session = request.getSession();
                session.setAttribute("products", listOfProducts);
                
                session.setAttribute("userName",username);
                response.sendRedirect("loginsuccess.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("userName", username);
                response.sendRedirect("failure.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
