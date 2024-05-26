package controller.cart;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Cart;
import entity.Product;
import entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;
import service.ProductService;
import service.UserService;

@WebServlet(value = "/insertCart.do")
public class CartInsertController extends HttpServlet {
    // 장바구니 추가
    // 입력 정보: User, product

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // buffer
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(req.getInputStream(), StandardCharsets.UTF_8));
        String line;

        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        String payload = buffer.toString();
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> data = mapper.readValue(payload, Map.class);
            String productId = (String) data.get("productId");
            String userId = (String) req.getSession().getAttribute("user");

            if (userId.isEmpty()) {
                // TODO ERROR
                return;
            }

            if (productId.isEmpty()) {
                // TODO ERROR
                return;
            }

            // 장바구니에 존재한다면
            CartService cartService = new CartService();
            Cart foundCart = cartService.findByUserIdAndProductId(userId, Integer.parseInt(productId));
            if (foundCart != null) {
                System.out.println("...");
                cartService.updateQuantity(foundCart.getId(), foundCart.getQuantity() + 1);
            } else {
                System.out.println("new");
                UserService userService = new UserService();
                User user = userService.findUserById(userId);

                ProductService productService = new ProductService();
                Product product = productService.find(Integer.parseInt(productId));

                Cart newCart = Cart.builder()
                        .quantity(1)
                        .user(user)
                        .product(product)
                        .build();
                cartService.save(newCart);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
