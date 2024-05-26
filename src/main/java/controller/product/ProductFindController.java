package controller.product;

import entity.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/productFind.do")
public class ProductFindController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        ProductService productService = new ProductService();
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("user");


        if (userId != null && !userId.isEmpty()) {
            List<Product> productUserFinadAll = productService.findUserProductListAll();

            req.setAttribute("productUser", productUserFinadAll);

            req.getRequestDispatcher("/views/productUser.jsp").forward(req, resp);

        }

//		String sellerId = (String) session.getAttribute("seller");
		String sellerId = "123456789";
		System.out.println(sellerId);
        if (sellerId != null) {
            List<Product> products = productService.findAllBySellerId(sellerId);
            for (Product product : products) {
                System.out.println(product.getPrice());
            }
            req.setAttribute("productSeller", products);
            resp.sendRedirect("/views/seller.jsp");
        }
    }
}
