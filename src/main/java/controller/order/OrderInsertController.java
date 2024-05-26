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

@WebServlet(value = "/insertOrder")
public class OrderInsertController extends HttpServlet {
    // 주문 추가
    // 입력 정보: User, product

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        UserService userService = new UserService();
//        ProductService productService = new ProductService();
//        OrderService orderService = new OrderService();
//        CartService cartService = new CartService();
//        // 유저가 주문했을 경우 주문 내역을 추가한다.
//        String userId = (String) req.getSession().getAttribute("user");
//        // 장바구니에서 주문할 경우 제품 여러 개가 올 수도 있다.
////        String products = (String) req.getAttribute("products");
//        String[] products = req.getParameterValues("products");
//        System.out.println(Arrays.toString(products));
//
//        if (userId.isEmpty() || products.length == 0) {
//            // TODO ERROR : MISSING Parameter
//            return;
//        }
//
//        List<Order> orders = new ArrayList<>();
//
//
//        // TODO : 2개 이상 선택 시 오류 발생
//        for (String productId : products) {
//
//            Cart temp = cartService.find(Integer.parseInt(productId));
//
//            orders.add(Order.builder()
//                    .user(userService.findUserById(userId))
//                    .quantity(temp.getQuantity())
//                    .product(temp.getProduct())
//                    .orderedDate(LocalDate.now())
//                    .build());
//
//            cartService.remove(Integer.parseInt(productId));
//
//        }
//
//        orderService.saveAll(orders);
//    }


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
            // TODO ERROR : MISSING Parameter
            return;
        }

        cartService.removeAll(cartIds);
        orderService.saveAll(orders);
    }
}
