package service;

import entity.Category;
import repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService() {
        categoryRepository = new CategoryRepository();
    }
//    public void insertCategory(Category category) {
//        categoryRepository.insertCategory(category);
//    }
    public Category findCategory(String categoryName) {
        return categoryRepository.findCategory(categoryName);
    }

    public void delectCategory(Category category) {
        categoryRepository.deleteCategory(category.getId());

    }

    public void saveAll(List<Category> categoryCpu) {
        categoryRepository.saveAll(categoryCpu);
    }

    public List<Category> insertCategoryService(Category category) {
        return categoryRepository.insertCategory(category.getId());
    }

    public void off() {
        categoryRepository.off();
    }
}
