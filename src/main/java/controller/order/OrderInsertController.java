package controller.order;

import entity.Cart;
import entity.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;
import service.OrderService;

@WebServlet(value = "/insertOrder.do")
public class OrderInsertController extends HttpServlet {
    // 주문 추가
    // 입력 정보: User, product

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        OrderService orderService = new OrderService();
        CartService cartService = new CartService();

        // 유저가 주문했을 경우 주문 내역에 데이터 추가한다.
        // 장바구니에 있는 제품 여러 개가 요청해올 수 있다.

        String[] carts = req.getParameterValues("products"); // 3, 3, 5
        List<Order> orders = new ArrayList<>();
        List<Integer> cartIds = new ArrayList<>();

        if (carts != null) {
            for (String cartId : carts) {
                System.out.println(cartId);
                Cart cart = cartService.find(Integer.parseInt(cartId));
                if (cart == null) {
                    String error = "서버 에러가 발생했습니다.: cart not found";
                    req.setAttribute("error", error);
                    req.getRequestDispatcher("/views/errors/error.jsp").forward(req, resp);
                }
                Order newOrder = Order.builder()
                        .user(cart.getUser())
                        .product(cart.getProduct())
                        .quantity(cart.getQuantity())
                        .build();
                System.out.println(newOrder);
                orders.add(newOrder);
                cartIds.add(Integer.parseInt(cartId));
            }
        } else {
            String error = "정상적인 요청이 아닙니다.";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/views/errors/error.jsp").forward(req, resp);
            return;
        }

        cartService.removeAll(cartIds);
        orderService.saveAll(orders);

        resp.sendRedirect("http://localhost:8080/orders.do");
    }
}
