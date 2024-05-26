package controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;
import entity.Product;
import entity.Seller;
import service.ProductService;

@WebServlet(value = "/productUpdate.do")
public class ProductUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	ProductService productService = new ProductService();


    	String productId = req.getParameter("id");
    	String productPrice = req.getParameter("productPrice");
    	String productDescription = req.getParameter("description");
    	String productStock = req.getParameter("stock");
    	String productName = req.getParameter("name");

    	Product product = new Product();
    	try {

    		int productIdInt = Integer.parseInt(productId);
    		int productPriceInt = Integer.parseInt(productPrice);
    		int productStockInt = Integer.parseInt(productStock);

    		product = Product.builder()
    				.id(productIdInt)
    				.price(productPriceInt)
    				.description(productDescription)
    				.stock(productStockInt)
    				.name(productName)
					.seller(Seller.builder().build())
					.category(Category.builder().build())
    				.build();


    		Boolean result = productService.updateProduct(product);
			if(result != false){
				resp.sendRedirect("/views/productSeller.jsp");
			}
		} catch (Exception e) {
			System.out.println(e);

		}
    }
}
