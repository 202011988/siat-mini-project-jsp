package controller.cart;

import entity.Cart;
import entity.Order;
import service.CartService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/cart.do")
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        CartService cartService = new CartService();

        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("user");


        List<Cart> cartlist = cartService.getCartListByUserId(userId);

        req.setAttribute("cartlist", cartlist);
        req.getRequestDispatcher("/views/basket.jsp").forward(req, resp);

    }
}
