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
        Product product = productService.find(Integer.parseInt(productId));

        req.setAttribute("product", product);
        req.getRequestDispatcher("views/detailProduct.jsp").forward(req, resp);
    }
}
