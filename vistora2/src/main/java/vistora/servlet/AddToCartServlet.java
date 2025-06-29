package vistora.servlet;

import vistora.model.Product;
import vistora.model.CartItem;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/cart")
public class AddToCartServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final List<Product> productList = Arrays.asList(
        new Product(1, "Paper Bag", "100% Eco Bags", 5.00, "images/download (1).jpg"),
        new Product(2, "Biodegradable Mailer", "Compostable envelope", 9.00, "images/download (2).jpg"),
        new Product(3, "Glasses & Straws", "Reusable biodegradable", 11.00, "images/download (3).jpg"),
        new Product(4, "Corrugated Box", "5‑ply eco box", 25.00, "images/download (4).jpg"),
        new Product(5, "Couriers Bag", "Compostable mailer", 8.00, "images/download.jpg"),
        new Product(6, "Courier Bags", "Compostable mailing envelope", 12.00, "images/images (1).jpg"),
        new Product(7, "Biodegradable Mailer 2", "Compostable mailing envelope", 16.00, "images/images (2).jpg"),
        new Product(8, "Shipping Box", "4x4x1.5 corrugated box", 10.00, "images/images (3).jpg"),
        new Product(9, "Food Packaging Boxes", "Compostable food packaging", 20.00, "images/images.jpg"),
        new Product(10, "Eco-Friendly Glasses", "Biodegradable drinkware", 14.00, "images/images (5).jpg"),
        new Product(11, "Eco Boxes With Lids", "Reusable containers", 9.00, "images/download IMAGE.jpg"),
        new Product(12, "Craft Paper Mailer", "Recyclable poly mailer", 8.00, "images/images (8).jpg")

    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();
        @SuppressWarnings("unchecked")
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        String add = req.getParameter("add");
        if (add != null) {
            int pid = Integer.parseInt(add);

            Product selectedProduct = null;
            for (Product p : productList) {
                if (p.getId() == pid) {
                    selectedProduct = p;
                    break;
                }
            }

            if (selectedProduct != null) {
                boolean found = false;
                for (CartItem item : cart) {
                    if (item.getProduct().getId() == pid) {
                        item.getQuantity();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    cart.add(new CartItem(selectedProduct, 1));
                }
            }
        }

        res.sendRedirect("cart.html");
    }
}
