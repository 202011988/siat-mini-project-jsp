package controller.product;

import entity.Product;
import entity.User;
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

		User user = (User) req.getSession().getAttribute("user");
		HttpSession session = req.getSession();
		session.setAttribute("user", user.getUserId());

    	ProductService productService = new ProductService();
		String userId = req.getParameter("user");

		if(userId != null && !userId.isEmpty()){
			List<Product> productUserFinadAll = productService.findUserProductListAll();
			req.setAttribute("productUserFinadALl", productUserFinadAll);
			resp.sendRedirect("/views/productUser.jsp");
		}


		String sellerId = req.getParameter("registration_number");
	 	if(sellerId != null && !sellerId.isEmpty()){
		List<Product> products = productService.findAllBySellerId(sellerId);
		req.setAttribute("products", products);
			resp.sendRedirect("/views/productSeller.jsp");
		}
    }
}
