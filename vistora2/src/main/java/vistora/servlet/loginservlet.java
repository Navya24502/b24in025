package vistora.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import vistora.servlet.*;

@WebServlet("/LoginServlet")
public class loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String USER_EMAIL = "aa@gmail.com";
    private static final String USER_PASSWORD = "navya";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        
        try{  
        	Class.forName("com.mysql.jdbc.Driver");  
        	//Create Connection
        	Connection con=DriverManager.getConnection(  
        			 "jdbc:mysql://localhost:3306/navya", "root", "navya123");  
        	  
        	//Create Statement for inserting details to table
        	PreparedStatement ps=con.prepareStatement("insert into login values(?,?)");  
        	  
        	ps.setString(1,email);  
        	ps.setString(2,password);  
        	          
        	int i=ps.executeUpdate();  
        	if(i>0)
        	{
        	System.out.print("You are successfully registered.... Please login to continue");  
        	request.getRequestDispatcher("index.html").include(request, response);
        	}
        }
        catch (Exception e2) 
        	{
        		System.out.println(e2);
        	}  
        	          
        	System.out.close();  
        	  
        
        
        if (USER_EMAIL.equals(email) && USER_PASSWORD.equals(password)) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
