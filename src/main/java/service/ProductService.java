package service;

import java.util.List;

import entity.Category;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Transient;
import util.JPAUtil;

public class ProductService {

    EntityManager em;
    EntityTransaction tx;

    public ProductService() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Transient
    public void save(Product product) {
        em.persist(product);

        tx.commit();
    }

    public List<Integer> getProductList() {
        String sql = "SELECT d FROM product d";
        return em.createNativeQuery(sql).getResultList();
    }

    public Product findProduct(Integer registrationNumber, Category category, Integer price
    		,String description, Integer stock, String name) {
        String sql = "SELECT p FROM product p";
        Product product = null;
        try {
        	product =  em.createQuery(sql, Product.class)
                    .setParameter("registrationNumber", registrationNumber)
                    .setParameter("category", category)
                    .setParameter("price", price)
                    .setParameter("description", description)
                    .setParameter("stock", stock)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return product;
    }



    public void off() {
        em.close();
    }


}
