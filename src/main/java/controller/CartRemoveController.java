package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;

@WebServlet(value = "/cart-remove")
public class CartRemoveController extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Integer cardId = Integer.parseInt(req.getParameter("cartId"));
        System.out.println(cardId);
        CartService cartService = new CartService();

        cartService.remove(cardId);
    }
}
