package repository;

import entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;
import util.JPAUtil;

public class OrderRepository {
    EntityManager em;
    EntityTransaction tx;

    public OrderRepository() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    public void save(Order order) {
        em.persist(order);
        tx.commit();
    }

    public void saveAll(List<Order> orders) {
        for (Order order : orders) {
            em.persist(order);
        }
        tx.commit();
    }

    public List<Order> findAllByUserId(String userId) {
        String sql = "SELECT o FROM Order o where o.user.id = :userId";
        TypedQuery<Order> query = em.createQuery(sql, Order.class).setParameter("userId", userId);

        return query.getResultList();
    }
}
