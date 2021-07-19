package com.prodmgmnt;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class LoginDao {

    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = (Connection) DriverManager
            .getConnection("jdbc:mysql://localhost:3306/product_management?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = (PreparedStatement) connection
            .prepareStatement("select * from users where user_name = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = (ResultSet) preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    
    public List<Map<String,String>> getAllProducts() throws ClassNotFoundException {
    	
    	List<Map<String,String>> l = new ArrayList<>();

    	Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = (Connection) DriverManager
            .getConnection("jdbc:mysql://localhost:3306/product_management?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = (PreparedStatement) connection
            .prepareStatement("select * from products")) {

            System.out.println(preparedStatement);
            ResultSet rs = (ResultSet) preparedStatement.executeQuery();
            while(rs.next()) {
            	Map<String,String> map = new HashMap();
            	map.put("product_id", rs.getString("product_id"));
            	map.put("product_name", rs.getString("product_name"));
            	l.add(map);
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return l;
    }
}
