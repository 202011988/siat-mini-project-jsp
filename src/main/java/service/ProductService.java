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

    public Boolean insertProduct(Product product) {
       return productRepository.insertProduct(product);
    }

    public Boolean updateProduct(Product product) {
        return productRepository.updateProduct(product);

    }

    public Boolean deleteProduct(int productId) {
       return productRepository.delectProduct(productId);
    }
}