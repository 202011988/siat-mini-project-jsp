package controller.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.OrderService;
import service.ProductService;
import service.UserService;

@WebServlet(value = "/insertOrder")
public class OrderInsertController extends HttpServlet {
    // 주문 추가
    // 입력 정보: User, product

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserService userService = new UserService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        // 유저가 주문했을 경우 주문 내역을 추가한다.
        String userId = (String) req.getSession().getAttribute("user_id");
        // 장바구니에서 주문할 경우 제품 여러 개가 올 수도 있다.
        String products = (String) req.getAttribute("products");

        if (userId.isEmpty() || products.isEmpty()) {
            // TODO ERROR : MISSING Parameter
            return;
        }

//        List<Order> orders = new ArrayList<>();
//
//        for (String productId : products.split(", ")) {
//            orders.add(Order.builder()
//                    .user(userService.findUserById(Integer.parseInt(userId)))
//                    .quantity(1)
//                    .product(productService.find(Integer.parseInt(productId)))
//                    .build());
//        }

//        orderService.saveAll(orders);
    }
}
