package service;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import util.JPAUtil;

public class UserService {

    EntityManager em;
    EntityTransaction tx;

    public UserService() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Transactional
    public void save(User user) {
        em.persist(user);
        tx.commit();
    }


    public void off() {
        em.close();
    }
}
