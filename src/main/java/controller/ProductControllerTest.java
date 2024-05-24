package controller;

import entity.Category;
import entity.Product;
import entity.Seller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CategoryService;
import service.ProductService;
import service.SellerService;
import service.UserService;

@WebServlet(value = "/productTest")
public class ProductControllerTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 테스트하기 위해 상품을 미리 등록한다.

        UserService userService = new UserService();
        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryService();
        SellerService sellerService = new SellerService();

        Category categoryCpu = new Category(null, "CPU");
        Category categoryBoard = new Category(null, "Board");
        categoryService.saveAll(List.of(categoryCpu, categoryBoard));

        Seller seller1 = new Seller(null, "seller", "storeName", "password", 123456789, 0);
        Seller seller2 = new Seller(null, "seller5", "storeName5", "password", 987654321, 15000);
        sellerService.saveAll(List.of(seller1, seller2));

        Product product1 = Product.builder()
                .id(null)
                .category(categoryCpu)
                .name("CPU i9999 무적의 CPU!!!!")
                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
                .price(100)
                .seller(seller1)
                .build();
        Product product2 = Product.builder()
                .id(null)
                .category(categoryCpu)
                .name("CPU i8888 무적의 CPU!!!!")
                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
                .price(100)
                .seller(seller1)
                .build();
        Product product3 = Product.builder()
                .id(null)
                .category(categoryCpu)
                .name("CPU i7777 무적의 CPU!!!!")
                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
                .price(100)
                .seller(seller1)
                .build();
        Product product4 = Product.builder()
                .id(null)
                .category(categoryCpu)
                .name("CPU i6666 무적의 CPU!!!!")
                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
                .price(100)
                .seller(seller1)
                .build();
        Product product5 = Product.builder()
                .id(null)
                .category(categoryCpu)
                .name("CPU i5555 무적의 CPU!!!!")
                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
                .price(100)
                .seller(seller1)
                .build();
        Product product6 = Product.builder()
                .id(null)
                .category(categoryCpu)
                .name("CPU i4444 무적의 CPU!!!!")
                .description("우주 초월한 CPU 입니다. 1조년 걸리는 복호화를 1초만에!")
                .price(100)
                .seller(seller1)
                .build();
        Product product99 = Product.builder()
                .id(null)
                .category(categoryBoard)
                .name("CPU i9999와 호환되는 국가권력급 우주 차세대 보드")
                .description("대역폭 무한입니다!!")
                .price(500)
                .seller(seller2)
                .build();
        productService.saveAll(
                List.of(product1, product2, product3, product4, product5, product6, product99));


    }
}
