package controller;

import entity.Category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CategoryService;
import service.ProductService;
import service.SellerService;

@WebServlet(value = "/productTest")
public class ProductControllerTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 테스트하기 위해 상품을 미리 등록한다.

        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryService();
        SellerService sellerService = new SellerService();

        Category categoryCpu = new Category(null, "CPU");
        Category categoryBoard = new Category(null, "Board");
//        categoryService.saveAll(List.of(categoryCpu, categoryBoard));

//        Seller seller1 = new Seller(null, "seller", "storeName", "password", 123456789, 0);
//        Seller seller2 = new Seller(null, "seller5", "storeName5", "password", 987654321, 15000);
//        sellerService.saveAll(List.of(seller1, seller2));

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
//                .category(categoryCpu)
//                .name("CPU i8888 무적의 CPU!!!!")
//                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
//                .price(100)
//                .seller(seller1)
//                .build();
//        Product product3 = Product.builder()
//                .id(null)
//                .category(categoryCpu)
//                .name("CPU i7777 무적의 CPU!!!!")
//                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
//                .price(100)
//                .seller(seller1)
//                .build();
//        Product product4 = Product.builder()
//                .id(null)
//                .category(categoryCpu)
//                .name("CPU i6666 무적의 CPU!!!!")
//                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
//                .price(100)
//                .seller(seller1)
//                .build();
//        Product product5 = Product.builder()
//                .id(null)
//                .category(categoryCpu)
//                .name("CPU i5555 무적의 CPU!!!!")
//                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
//                .price(100)
//                .seller(seller1)
//                .build();
//        Product product6 = Product.builder()
//                .id(null)
//                .category(categoryCpu)
//                .name("CPU i4444 무적의 CPU!!!!")
//                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
//                .price(100)
//                .seller(seller1)
//                .build();
//        Product product99 = Product.builder()
//                .id(null)
//                .category(categoryBoard)
//                .name("CPU i9999와 호환되는 국가권력급 우주 차세대 보드")
//                .description("대역폭 무한입니다!!")
//                .price(500)
//                .seller(seller2)
//                .build();
//        productService.saveAll(
//                List.of(product1, product2, product3, product4, product5, product6, product99));

        // 사용자가 해당 상품을 "담기" 했을 경우
        // 1
//        req.setAttribute(); // 애트리뷰트 등록한 후
//        req.getRequestDispatcher() // 으로 등록할 수 있어요.
        // 2 세션 이거는 이용 할 리 없고
//        req.getSession().setAttribute("productId", product6.getId());
        // 3 cart service 바로 등록
//        User user = new User(null, "user1", "password", "seoul", "nickname");
//        userService.save(user);

//        Cart cart = Cart.builder()
//                .user(user)
//                .product(product6)
//                .quantity(1)
//                .build();
//        cartService.save(cart);
    }
}