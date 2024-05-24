package controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;

@WebServlet(value = "/deleteCart.do")
public class CartRemoveController extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 장바구니 삭제
        // 입력 정보: Cart

        String cartId = req.getParameter("cartId");

        if (cartId.isEmpty()) {
            // TODO ERROR
            return;
        }

        CartService cartService = new CartService();

        // TODO Integer if 분기점
        System.out.println(cartService.remove(Integer.parseInt(cartId)));

    }
}
