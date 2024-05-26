package controller.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;
import service.CategoryService;

@WebServlet(value = "/categoryInsert.do")
public class CategoryInsertController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CategoryService categoryService = new CategoryService();

		String categoryId = req.getParameter("category_id");
		String categoryName = req.getParameter("name");

		Category category = new Category();

		try {
			int categoryIdInt = Integer.parseInt(categoryId);
			category = Category.builder()
					.id(categoryIdInt)
					.name(categoryName)
					.build();

			categoryService.insertCategoryService(category);


		} catch (Exception e) {
			System.out.println(e);
		}
		categoryService.off();
	}
}
