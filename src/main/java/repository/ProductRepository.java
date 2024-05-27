package repository;

import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

import util.JPAUtil;

public class ProductRepository {

    EntityManager em;
    EntityTransaction tx;

    public ProductRepository() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    public List<Product> findProductListAll() {
        String sql = "SELECT d FROM Product d";
        List<Product> productList = em.createQuery(sql, Product.class)
                .getResultList();
        return productList;
    }

    public List<Product> findAllBySellerId(Integer sellerId) {
        String sql = "SELECT d FROM Product d  WHERE d.seller.registrationNumber= :registrationNumber";
        List<Product> productList =
                em.createQuery(sql, Product.class)
                        .setParameter("registrationNumber", sellerId)
                        .getResultList();
        tx.commit();
        return productList;

    }

    public void saveAll(List<Product> product) {
        for (Product products : product) {
            em.persist(products);
        }
        tx.commit();
    }

    public void insertProduct(Product product) {
        em.persist(product);
        tx.commit();
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE Product p SET p.category = :category, p.description = :description, " +
                "p.name = :name, p.price = :price, p.stock = :stock WHERE p.id = :id";

        em.createQuery(sql)
                .setParameter("id", product.getId())
                .setParameter("category", product.getCategory())
                .setParameter("price", product.getPrice())
                .setParameter("description", product.getDescription())
                .setParameter("stock", product.getStock())
                .setParameter("name", product.getName())
                .executeUpdate();


        tx.commit();

    }

    public boolean delectProduct(Integer id) {
        String sql = "DELETE FROM Product p WHERE p.id = :id";
        Integer result = em.createQuery(sql, Product.class)
                .setParameter("id", id)
                .executeUpdate();
        tx.commit();
        return result > 0;
    }

    public void off() {
        em.close();
    }

    public Product find(int id) {
        Product product = null;
        product = em.find(Product.class, id);

        return product;
    }

}
