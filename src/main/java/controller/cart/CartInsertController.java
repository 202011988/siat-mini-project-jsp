package controller.cart;

import java.io.IOException;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserService userService = new UserService();
        ProductService productService = new ProductService();
        CartService cartService = new CartService();

        // product 호출
//        int productId = Integer.parseInt(req.getSession().getAttribute("productId").toString());
        String productId = req.getParameter("productId");
        String userId = (String) req.getSession().getAttribute("user_id");

        if (productId.isEmpty() || userId.isEmpty()) {
            // TODO ERROR : MISSING Parameter
            return;
        }

//        Product choseProduct = productService.find(Integer.parseInt(productId));

//        Cart newCart = Cart.builder()
//                .user(userService.findUserById(Integer.parseInt(userId)))
//                .quantity(1)
//                .product(choseProduct)
//                .build();

//        cartService.save(newCart);

        // TODO: response HTTPState
    }
}
