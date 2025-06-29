package vistora.servlet;

import vistora.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Product> productList;

    @Override
    public void init() throws ServletException {
        productList = new ArrayList<>();

        // Add dummy products
        productList.add(new Product(1, "Paper Bag", "100% Eco Bags", 5.00, "download (1).jpg"));
        productList.add(new Product(2, "Biodegradable Mailer", "Compostable mailing envelope", 9.00, "download (2).jpg"));
        productList.add(new Product(3, "Glasses and Straws", "Biodegradable materials", 11.00, "download (3).jpg"));
        productList.add(new Product(4, "Corrugated Box", "Box Brother 3 Ply Packaging Box", 25.00, "download (4).jpg"));
        // You can add more products here
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Products</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background-color: #f4f4f4; }");
        out.println(".product { border: 1px solid #ccc; padding: 16px; margin: 16px; display: inline-block; width: 250px; background: white; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
        out.println(".product img { width: 100%; height: 200px; object-fit: cover; border-radius: 5px; }");
        out.println(".product h3 { margin: 10px 0 5px; }");
        out.println(".product p { margin: 5px 0; }");
        out.println(".buy-btn { display: inline-block; padding: 8px 12px; background-color: green; color: white; text-decoration: none; border-radius: 5px; margin-top: 10px; }");
        out.println("</style></head><body>");
        out.println("<h1 style='text-align:center;'>Eco-Friendly Packaging Products</h1>");
        out.println("<div style='display:flex; flex-wrap:wrap; justify-content:center;'>");

        for (Product p : productList) {
            out.println("<div class='product'>");
            out.println("<img src='" + p.getImagePath() + "' alt='" + p.getName() + "'>");
            out.println("<h3>" + p.getName() + "</h3>");
            out.println("<p>" + p.getDescription() + "</p>");
            out.println("<p>Price: ₹" + p.getPrice() + "</p>");
            out.println("<a class='buy-btn' href='buy?productId=" + p.getId() + "'>BUY NOW</a>");
            out.println("</div>");
        }

        out.println("</div>");
        out.println("</body></html>");
    }
}
