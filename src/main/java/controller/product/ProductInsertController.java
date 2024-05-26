package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.CategoryService;
import service.ProductService;

@WebServlet(value = "/productInsert.do")
public class ProductInsertController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	ProductService productService = new ProductService();
		CategoryService categoryService = new CategoryService();
		String sellerId = req.getParameter("registration_number");
		if(sellerId != null && !sellerId.isEmpty()){

    	String productId = req.getParameter("id");
    	String productPrice = req.getParameter("productPrice");
    	String productDescription = req.getParameter("description");
    	String productStock = req.getParameter("stock");
    	String productName = req.getParameter("name");
		String categoryName = req.getParameter("category");

    	Product product = new Product();
    	
    	try {
    		int productIdInt = Integer.parseInt(productId);
    		int productPriceInt = Integer.parseInt(productPrice);
    		int productStockInt = Integer.parseInt(productStock);
    		
    		product = Product.builder()
    				.id(productIdInt)
    				.seller(product.getSeller())
					.category(categoryService.findCategory(categoryName))
    				.price(productPriceInt)
    				.description(productDescription)
    				.stock(productStockInt)
    				.name(productName)
    				.build();

    		Boolean result = productService.insertProduct(product);
			if(result != false){
				resp.sendRedirect("/views/productSeller.jsp");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		}
    }
}
