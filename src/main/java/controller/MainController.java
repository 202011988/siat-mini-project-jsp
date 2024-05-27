package controller;

import entity.Category;
import entity.Product;
import service.ProductService;
import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();


        if(session == null
                || (session.getAttribute("user") == null
                        && session.getAttribute("seller") == null)
                || session.getAttribute("user") != null) {

            CategoryService categoryService = new CategoryService();
            ProductService productService = new ProductService();

            List<Category> category = categoryService.findAll();
            List<Product> product = productService.findUserProductListAll();


            req.setAttribute("category", category);
            req.setAttribute("product", product);



            req.getRequestDispatcher("/views/virtualestimate.jsp").forward(req, resp);
        }

        else if (session.getAttribute("seller") != null) {
            resp.sendRedirect("/views/seller.jsp");
        }

    }
}