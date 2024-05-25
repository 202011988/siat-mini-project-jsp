package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import entity.Seller;
import service.ProductService;

@WebServlet(value = "/product")
public class ProductController extends HttpServlet {

    ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	productService = new ProductService();
    	
        Seller seller1 = new Seller(123456, "seller", "storeName", "password", 100);
        
        Product product1 = Product.builder()
                .id(null)
                .seller(seller1)
                .category(null)
                .price(162580)
                .description("AMD(소켓AM4) 4세대(Zen3) 7nm 6코어 12스레드 기본 클럭:3.9GHz 최대 클럭:4.4GHz L2 캐시:3MB L3 캐시:16MB TDP:65W PCIe3.0 메모리 규격:DDR4 3200MHz 내장그래픽: 탑재 AMD 라데온 그래픽 7 기술 지원:하이퍼스레딩/SMT,SenseMI,AMD Ryzen Master 쿨러:Wraith Stealth 포함 시네벤치R23(싱글):1446 시네벤치R23(멀티):10489")
                .stock(100)
                .name("AMD 라이젠5-4세대 5600G (세잔) (멀티팩(정품))")
                .build();
//        productService.save(product1);

        
//        productService.off();
    }
}
