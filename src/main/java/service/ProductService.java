package service;

import entity.Product;
import java.util.List;
import repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    public void saveAll(List<Product> product) {
        productRepository.saveAll(product);
    }

    public void findProductListAll() {
        productRepository.findProductListAll();
    }

    public void insertProduct(Product product) {
        productRepository.insertProduct(product);
    }

    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    public void delectProduct(Product product) {
        productRepository.delectProduct(product.getId());
    }

    public Product find(int id) {
        return productRepository.find(id);
    }
}