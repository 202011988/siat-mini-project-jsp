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

@WebServlet(value = "/productInsertInput.do")
public class ProductInsertInputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryService categoryService = new CategoryService();
        req.setAttribute("category", categoryService.findAll());

        req.getRequestDispatcher("views/productInsert.jsp").forward(req, resp);
    }
}
