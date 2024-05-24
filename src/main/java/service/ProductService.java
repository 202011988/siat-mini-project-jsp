package service;

import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import java.util.List;
import util.JPAUtil;

public class ProductService {

    EntityManager em;
    EntityTransaction tx;

    public ProductService() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Transactional
    public void save(Product product) {
        em.persist(product);
        tx.commit();
    }

    @Transactional
    public void saveAll(List<Product> products) {
        for (Product product : products) {
            em.persist(product);
        }
        tx.commit();
    }

    public void off() {
        em.close();
    }
}
