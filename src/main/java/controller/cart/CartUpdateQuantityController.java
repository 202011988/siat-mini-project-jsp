package controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;

@WebServlet(value = "/updateCartWithQuantity")
public class CartUpdateQuantityController extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 장바구니 수량 조절
        // 입력 정보: Cart

        String cartId = req.getParameter("cartId");
        String quantity = req.getParameter("quantity");

        if (cartId.isEmpty() || quantity.isEmpty()) {
            // TODO ERROR
        }

        CartService cartService = new CartService();

        // TODO Integer if 분기점
        System.out.println(cartService.updateQuantity(
                Integer.parseInt(cartId),
                Integer.parseInt(quantity)
        ));
    }
}
