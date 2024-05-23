package service;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Transient;
import java.util.List;
import util.JPAUtil;

public class UserService {

    EntityManager em;
    EntityTransaction tx;

    public UserService() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Transient
    public void save(User user) {
        em.persist(user);

        tx.commit();
    }

    public List<Integer> getUserList() {
        String sql = "SELECT id FROM users";
        return em.createNativeQuery(sql).getResultList();
    }

    public void off() {
        em.close();
    }
}
