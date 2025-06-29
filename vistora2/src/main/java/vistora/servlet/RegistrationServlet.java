

package vistora.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // For demonstration: print to console
        System.out.println("New user registered:");
        System.out.println("Full Name: " + fullname);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        // TODO: Save to database here if needed

        // Redirect to index.html after successful registration
        response.sendRedirect("index.html");
    }
}