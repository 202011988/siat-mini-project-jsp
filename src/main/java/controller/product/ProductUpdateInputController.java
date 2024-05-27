package controller.product;

import entity.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/productUpdateInput.do")
public class ProductUpdateInputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = (String) req.getParameter("productId");

        if (productId.isEmpty()) {
            // TODO ERROR
            return;
        }

        ProductService productService = new ProductService();
        Product product = productService.find(Integer.parseInt(productId));

        CategoryService categoryService = new CategoryService();
        req.setAttribute("category", categoryService.findAll());

        req.setAttribute("product", product);
        req.getRequestDispatcher("views/productUpdate.jsp").forward(req, resp);
    }
}
