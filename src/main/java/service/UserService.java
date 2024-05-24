package service;

import entity.Seller;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
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


    public User findUserById(int userId) {
        User user = null;
        user = em.find(User.class, userId);

        return user;
    }


    public void off() {
        em.close();
    }


}
