package controller;

import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;
import service.ProductService;
import service.UserService;

@WebServlet(value = "/cart")
public class CartController extends HttpServlet {

    CartService cartService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserService userService = new UserService();
        ProductService productService = new ProductService();

        cartService = new CartService();

        // product 호출
        int productId = Integer.parseInt(req.getSession().getAttribute("productId").toString());

        Product product = productService.find(productId);
//
//        Cart cart = Cart.builder()
//                .user(user)
//                .product(product)
//                .quantity(1)
//                .build();

//        cartService.save(cart);

        PrintWriter out = resp.getWriter();
//        List<Cart> cartList = cartService.getCartListByUserId(user.getId());

//        for (Cart value : cartList) {
//            System.out.println(
//                    value.getUser() + " : " + value.getProduct().getName() + " : "
//                            + value.getQuantity());
//            out.println(value.getUser().getNickname() + " : " + value.getProduct().getName() + " : "
//                    + value.getQuantity());
    }
}
