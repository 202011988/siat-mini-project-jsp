package service;

import entity.Category;
import repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService() {
        categoryRepository = new CategoryRepository();
    }

    public Category findCategory(String categoryName) {
        return categoryRepository.findCategory(categoryName);
    }

    public void deleteProduct(Category category) {
        categoryRepository.deleteProduct(category.getId());

    }

    public Category findCategoryById(int categoryId) {
        return categoryRepository.findCategoryById(categoryId);
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

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
