package repository;

import entity.Product;
import entity.User;
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
        String sql = "SELECT d FROM Product d ";
        List<Product> productList = em.createQuery(sql, Product.class).getResultList();
        return productList;
    }

    public void saveAll(List<Product> product) {
        for (Product products : product) {

            em.persist(products);
        }

    }

    public void insertProduct(Product product) {
        em.persist(product);
        tx.commit();
//        String sql = "INSERT INTO Product (id, seller, category, price, description, stock, name) VALUE (p.id= :i, p.seller= :s, p.categoty= :c, p.price= :p, p.description= :d, p.stock= :st, p.name= :n)";
//        Product productInsert = (Product) em.createQuery(sql, Product.class)
//                .setParameter("i", product.getId())
//                .setParameter("s", product.getSeller().getRegistrationNumber())
//                .setParameter("c", product.getCategory().getId())
//                .setParameter("p", product.getPrice())
//                .setParameter("d", product.getDescription())
//                .setParameter("st", product.getStock())
//                .setParameter("n", product.getName()).getResultList();
//        tx.commit();
//        return productInsert;
    }

    public Product updateProduct(Product product) {
        String sql = "UPDATE Product p SET p.id= :i, p.seller= :s, p.category = :c"
                + ",p.price= :p, p.description= :d, p.stock= :st, p.name= :n";
        Product productUpdate = (Product) em.createQuery(sql, Product.class)
                .setParameter("i", product.getId())
                .setParameter("s", product.getSeller().getRegistrationNumber())
                .setParameter("c", product.getCategory().getId())
                .setParameter("p", product.getPrice())
                .setParameter("d", product.getDescription())
                .setParameter("st", product.getStock())
                .setParameter("n", product.getName()).getResultList();
        tx.commit();
        return productUpdate;

    }

    public Product delectProduct(Integer id) {
        String sql = "DELETE FROM Product p WHERE p.id = :id";
        Product productDelete = em.createQuery(sql, Product.class).setParameter("id", id)
                .getSingleResult();
        tx.commit();
        return productDelete;

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
