package service;

import jakarta.transaction.Transactional;
import java.util.List;

import entity.Category;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Transient;
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

    public List<Integer> getCategoryList() {
        String sql = "SELECT c FROM category c";
        return em.createNativeQuery(sql).getResultList();
    }

    public Category findCategory(String name) {
        String sql = "SELECT p FROM product p";
        Category category = null;
        try {
        	category =  em.createQuery(sql, Category.class)
                    .setParameter("CPU", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return category;
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
