package controller;

import entity.Cart;
import entity.Category;
import entity.Order;
import entity.Product;
import entity.Seller;
import entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;
import service.CategoryService;
import service.OrderService;
import service.ProductService;
import service.SellerService;
import service.UserService;

@WebServlet(value = "/test")
public class StartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserService userService = new UserService();
        CategoryService categoryService = new CategoryService();
        SellerService sellerService = new SellerService();
        ProductService productService = new ProductService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();

        // Given
        User user = new User("user1", "password", "seoul", "name");
        userService.save(user);

        Category categoryCpu = new Category(null, "CPU");
        Category categoryBoard = new Category(null, "Board");
        categoryService.saveAll(List.of(categoryCpu, categoryBoard));

        Seller seller1 = new Seller(123456789, "seller", "storeName", "password", 0);
        Seller seller2 = new Seller(987654321, "seller5", "storeName5", "password", 15000);
        sellerService.saveAll(List.of(seller1, seller2));

        Product product1 = Product.builder()
                .id(null)
                .category(categoryCpu)
                .name("CPU i9999 무적의 CPU!!!!")
                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
                .price(100)
                .seller(seller1)
                .stock(100)
                .build();
        Product product2 = Product.builder()
                .id(null)
                .category(categoryBoard)
                .name("CPU i9999와 호환되는 국가권력급 우주 차세대 보드")
                .description("대역폭 무한입니다!!")
                .price(500)
                .stock(100)
                .seller(seller2)
                .build();
        productService.saveAll(List.of(product1, product2));

        Cart cart1 = Cart.builder()
                .user(user)
                .product(product1)
                .quantity(1)
                .build();
        Cart cart2 = Cart.builder()
                .user(user)
                .product(product2)
                .quantity(2)
                .build();
        cartService.saveAll(List.of(cart1, cart2));

        Order order1 = Order.builder()
                .product(product1)
                .quantity(5)
                .user(user)
                .build();
        orderService.save(order1);
    }
}