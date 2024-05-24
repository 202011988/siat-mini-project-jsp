package controller;

import entity.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;

@WebServlet(value = "/cart")
public classgit CartController extends HttpServlet {

    CartService cartService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        cartService = new CartService();

        PrintWriter out = resp.getWriter();
        List<Cart> cartList = cartService.getCartList();

        for (Cart cart : cartList) {
            out.println(cart.getUser().getNickname() + " : " + cart.getPrice());
        }

        cartService.off();
    }
}
