package controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;

@WebServlet(value = "/productRemove.do")
public class ProductRemoveController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        
        ProductService productServer = new ProductService();


        String productName = req.getParameter("productName");
        System.out.println(productName);
        if (productName != null && !productName.isEmpty()) {
            System.out.println(productName);
        }


        String productId = req.getParameter("product_id");
        Boolean result = productServer.deleteProduct(11);
        if(result != false){
            resp.sendRedirect("/views/seller.jsp");
        }

    }
}
