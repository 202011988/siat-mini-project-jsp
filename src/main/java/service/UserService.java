package service;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
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

    public void save(User user) {
        em.persist(user);
        tx.commit();
    }


    public User findUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT u FROM User u WHERE u.username = :id AND u.password = :pw";
        User user = null;
        try {
        	
            user =  em.createQuery(sql, User.class)
                    .setParameter("id", username)
                    .setParameter("pw", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return user;
    }


    public User findUserById(String userId) {
        User user = null;
        user = em.find(User.class, userId);

        return user;
    }


    public void off() {
        em.close();
    }


}
