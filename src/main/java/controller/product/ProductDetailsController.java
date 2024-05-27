package controller.product;

import entity.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProductService;

@WebServlet(value = "/productDetails.do")
public class ProductDetailsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String productId = req.getParameter("productId");

        if (productId.isEmpty()) {
            // TODO ERROR
            return;
        }

        ProductService productService = new ProductService();
        Product product = productService.find(Integer.parseInt(productId)); // product ID로 product 조회한 후
        // detail 상세 페이지에 넘겨주는 방식입니다.
        // productDetails.do 으로 넘겨주면서
        // get 방식으로 id를 넘겨주면 됩니다.
        // 참고할 페이지는 order-list.jsp 입니다.
        // 해볼 수 있겠어요?


        req.setAttribute("product", product);
        req.getRequestDispatcher("views/detailProduct.jsp").forward(req, resp);
    }
}
