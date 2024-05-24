package service;

import entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import java.util.List;
import util.JPAUtil;

public class CategoryService {

    EntityManager em;
    EntityTransaction tx;

    public CategoryService() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Transactional
    public void save(Category category) {
        em.persist(category);
        tx.commit();
    }

    @Transactional
    public void saveAll(List<Category> categories) {
        for (Category category : categories) {
            em.persist(category);
        }
        tx.commit();
    }

    public void off() {
        em.close();
    }
}
