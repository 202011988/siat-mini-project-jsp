package controller;

import entity.Category;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;
import service.UserService;

@WebServlet(value = "/categoty")
public class CategoryController extends HttpServlet {

    CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	categoryService = new CategoryService();

    	categoryService.save(
    			Category.builder().name("CPU").build());

        PrintWriter out = resp.getWriter();
        for (int id : categoryService.getCategoryList()) {
            out.println(id);
        }

        categoryService.off();
    }
}
