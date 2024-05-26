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
        System.out.println(productList);
        return productList;
    }

    public List<Product> findAllBySellerId(String sellerId) {
        String sql = "SELECT d FROM Product d  WHERE d.seller.registrationNumber= :registrationNumber";
        List<Product> productList =
                em.createQuery(sql, Product.class)
                        .setParameter("registrationNumber", sellerId)
                        .getResultList();
        tx.commit();
        System.out.println(productList);
        return productList;

    }

    public void saveAll(List<Product> product) {
        for (Product products : product) {
            em.persist(products);
        }
        tx.commit();
    }

public boolean insertProduct(Product product) {
    String sql = "INSERT INTO Product (id) VALUES (:i, :s, :c, :p, :d, :st, :n)";
    Product productInsert = (Product) em.createQuery(sql, Product.class)
                .setParameter("i", product.getId())
                .setParameter("s", product.getSeller().getRegistrationNumber())
                .setParameter("c", product.getCategory().getId())
                .setParameter("p", product.getPrice())
                .setParameter("d", product.getDescription())
                .setParameter("st", product.getStock())
                .setParameter("n", product.getName()).getResultList();
        tx.commit();
        return productInsert != null;
}

    public Boolean updateProduct(Product product) {
        String sql = "UPDATE Product p SET p.id= :i, p.category = :c"
                + ",p.price= :p, p.description= :d, p.stock= :st, p.name= :n where p.id= :id" ;
        Product productUpdate = (Product) em.createQuery(sql, Product.class)
                .setParameter("i", product.getId())
                .setParameter("id", product.getSeller().getRegistrationNumber())
                .setParameter("c", product.getCategory().getId())
                .setParameter("p", product.getPrice())
                .setParameter("d", product.getDescription())
                .setParameter("st", product.getStock())
                .setParameter("n", product.getName()).getResultList();
        tx.commit();
        return productUpdate != null;

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



}
