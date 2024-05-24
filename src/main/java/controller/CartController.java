package controller;

import entity.Cart;
import entity.Product;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

        // 가상 유저
        User user = new User(null, "user1", "password", "seoul", "nickname");
        userService.save(user);

//        Category categoryCpu = new Category(null, "CPU");
//        Category categoryBoard = new Category(null, "Board");
//        categoryService.saveAll(List.of(categoryCpu, categoryBoard));
//
//        Seller seller1 = new Seller(null, "seller", "storeName", "password", 123456789, 0);
//        Seller seller2 = new Seller(null, "seller5", "storeName5", "password", 987654321, 15000);
//        sellerService.saveAll(List.of(seller1, seller2));
//
//        Product product1 = Product.builder()
//                .id(null)
//                .category(categoryCpu)
//                .name("CPU i9999 무적의 CPU!!!!")
//                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
//                .price(100)
//                .seller(seller1)
//                .build();
//        Product product2 = Product.builder()
//                .id(null)
//                .category(categoryBoard)
//                .name("CPU i9999와 호환되는 국가권력급 우주 차세대 보드")
//                .description("대역폭 무한입니다!!")
//                .price(500)
//                .seller(seller2)
//                .build();
//        productService.saveAll(List.of(product1, product2));

//        Cart cart1 = Cart.builder()
//                .user(user)
//                .product(product1)
//                .quantity(1)
//                .build();
//        Cart cart2 = Cart.builder()
//                .user(user)
//                .product(product2)
//                .quantity(2)
//                .build();
//        cartService.saveAll(List.of(cart1, cart2));

        // product 호출
        int productId = Integer.parseInt(req.getSession().getAttribute("productId").toString());

        Product product = productService.find(productId);

        Cart cart = Cart.builder()
                .user(user)
                .product(product)
                .quantity(1)
                .build();

        cartService.save(cart);

        PrintWriter out = resp.getWriter();
        List<Cart> cartList = cartService.getCartListByUserId(user.getId());

        for (Cart value : cartList) {
            System.out.println(
                    value.getUser().getNickname() + " : " + value.getProduct().getName() + " : "
                            + value.getQuantity());
//            out.println(value.getUser().getNickname() + " : " + value.getProduct().getName() + " : "
//                    + value.getQuantity());
        }
    }
}
