package controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import entity.Seller;
import service.CartService;
import service.ProductService;
import service.UserService;

    @WebServlet(value = "/productRemove.")
public class ProductRemoveController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        
        ProductService productServer = new ProductService();
        String productId = req.getParameter("product_id");
        productServer.delectProduct(Integer.parseInt(productId));

    }
}
