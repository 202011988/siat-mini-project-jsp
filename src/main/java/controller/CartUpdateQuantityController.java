package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;

@WebServlet(value = "/cart-update-quantity")
public class CartUpdateQuantityController extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int cartId = (int) req.getAttribute("cartId");
        int quantity = (int) req.getAttribute("quantity");

        CartService cartService = new CartService();
        cartService.updateQuantity(cartId, quantity);


    }
}
