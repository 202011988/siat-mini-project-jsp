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

    public boolean insertProduct(Product product) {
        String sql = "INSERT INTO Product (id) VALUES (:s, :c, :p, :d, :st, :n)";
        Product productInsert = (Product) em.createQuery(sql, Product.class)
                .setParameter("s", product.getSeller().getRegistrationNumber())
                .setParameter("c", product.getCategory().getId())
                .setParameter("p", product.getPrice())
                .setParameter("d", product.getDescription())
                .setParameter("st", product.getStock())
                .setParameter("n", product.getName()).getResultList();
        tx.commit();
        return productInsert != null;
    }

    public void updateProduct(Product product, Integer category, Integer sellerId) {

        String sql = "UPDATE Product p SET p.category.id = :categoryId, p.description = :description, " +
                "p.name = :name, p.price = :price, p.stock = :stock WHERE p.id = :id";
//        String sql = "UPDATE Product p SET  p.category.id = :c"
//                + ",p.price= :p, p.description= :d, p.stock= :st, p.name= :n WHERE p.seller.registrationNumber = :sellerId" ;
        System.out.println();
        em.createQuery(sql)
//                .setParameter("", sellerId)
                .setParameter("id", product.getId())
                .setParameter("categoryId", category)
                .setParameter("price", product.getPrice())
                .setParameter("description", product.getDescription())
                .setParameter("stock", product.getStock())
                .setParameter("name", product.getName())
                .executeUpdate();

//        em.persist(productUpdate);
//        tx.commit();

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
