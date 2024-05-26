package repository;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import util.JPAUtil;

public class UserRepository {

    EntityManager em;
    EntityTransaction tx;

    public UserRepository() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Transactional
    public void save(User user) {
        em.persist(user);
        tx.commit();
    }


    public User findUserByUserIdAndPassword(String userId, String password) {
        String sql = "SELECT u FROM User u WHERE u.userId = :id AND u.password = :pw";
        User user = null;
        try {

            user =  em.createQuery(sql, User.class)
                    .setParameter("id", userId)
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
