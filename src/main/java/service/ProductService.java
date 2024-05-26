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
    public List<Product> findAllBySellerId(String sellerId) {
        return productRepository.findAllBySellerId(sellerId);

    }

    public void insertProduct(Product product) {
        productRepository.insertProduct(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.updateProduct(product);

    }

    public void delectProduct(Integer product) {
        productRepository.delectProduct(product);

    }



}