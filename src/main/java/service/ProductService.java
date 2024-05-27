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


    public List<Product> findUserProductListAll() {

        return productRepository.findProductListAll();

    }
    public List<Product> findAllBySellerId(Integer sellerId) {
        return productRepository.findAllBySellerId(sellerId);

    }

    public void insertProduct(Product product) {
       productRepository.insertProduct(product);
    }


    public void updateProduct(Product product) {
        productRepository.updateProduct(product);

    }

    public Boolean deleteProduct(int productId) {
       return productRepository.delectProduct(productId);
    }

    public Product find(int id) {
        return productRepository.find(id);
    }
}