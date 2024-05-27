package service;

import entity.Category;
import repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService() {
        categoryRepository = new CategoryRepository();
    }

    public Category findCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(int categoryId) {
        return categoryRepository.findCategoryById(categoryId);
    }

    public void deleteProduct(Category category) {
        categoryRepository.deleteProduct(category.getId());
    }

    public void saveAll(List<Category> categoryCpu) {
        categoryRepository.saveAll(categoryCpu);
    }



    public void off() {
        categoryRepository.off();
    }


    public void insertCategoryService(Category category) {
    }
}
