package service;

import entity.Cart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import util.JPAUtil;

public class CartService {

    EntityManager em;
    EntityTransaction tx;

    public CartService() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    public boolean save(Cart cart) {
         em.persist(cart);

        tx.commit();
        return true;
    }

    public List<Cart> getCartList() {
        String sql = "SELECT id FROM carts";
        return em.createNativeQuery(sql).getResultList();
    }

    public void off() {
        em.close();
    }
}
