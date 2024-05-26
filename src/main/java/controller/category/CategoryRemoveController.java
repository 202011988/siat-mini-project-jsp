package controller.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;
import service.CategoryService;

@WebServlet(value = "/categoryRemove.do")
public class CategoryRemoveController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Category category = new Category();
        
        CategoryService categoryService = new CategoryService();
        categoryService.deleteProduct(category);

    }
}
