package controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Category;
import entity.Product;
import entity.Seller;
import service.CategoryService;
import service.ProductService;
import service.SellerService;

@WebServlet(value = "/productUpdate.do")
public class ProductUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


		HttpSession session = req.getSession();
		String productId = req.getParameter("productId");
		Integer sellerId = (Integer) session.getAttribute("seller");
		String productPrice = req.getParameter("productPrice");
		String productDescription = req.getParameter("description");
		String productStock = req.getParameter("stock");
		String productName = req.getParameter("name");
		String productCategory = req.getParameter("prodcutCategory");


		CategoryService categoryService = new CategoryService();
		SellerService sellerService = new SellerService();
		ProductService productService = new ProductService();

		Product product;

    	try {

    		int productPriceInt = Integer.parseInt(productPrice);
    		int productStockInt = Integer.parseInt(productStock);
			int productCategoryInt = Integer.parseInt(productCategory);
			int productIdInt = Integer.parseInt(productId);

			Category category = categoryService.findCategoryById(productCategoryInt);
			Seller seller = sellerService.findSellerById(sellerId);


    		product = Product.builder()
					.id(productIdInt)
					.price(productPriceInt)
					.description(productDescription)
					.stock(productStockInt)
					.name(productName)
					.seller(seller)
					.category(category)
					.build();


    		productService.updateProduct(product);	// 입력 받은 값을 쿼리해서 수정해서
			resp.sendRedirect("/productFind.do"); // 목록을 가져와서 출력하는 do 컨트롤러.

		} catch (Exception e) {
			System.out.println(e);

		}
    }
}
