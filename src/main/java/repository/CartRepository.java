package repository;

import entity.Cart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import util.JPAUtil;

public class CartRepository {

    EntityManager em;
    EntityTransaction tx;

    public CartRepository() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Transient
    public void save(Cart cart) {
        em.persist(cart);
        tx.commit();

//        off();
    }

    public List<Cart> findCartListByUserId(int userId) {
        String sql = "SELECT c FROM Cart c WHERE c.user.id = :userId";
        TypedQuery<Cart> query = em.createQuery(sql, Cart.class).setParameter("userId", userId);

//        off();
        return query.getResultList();
    }

    private void off() {
        em.close();
    }

    @Transactional
    public void saveAll(List<Cart> carts) {
        for (Cart cart : carts) {
            em.persist(cart);
        }
        tx.commit();
    }

    public void remove(Integer cartId) {
        em.remove(cartId);
    }

    public boolean updateQuantity(int cartId, int quantity) {
        String sql = "UPDATE Cart set quantity = :q where Cart.id = :id";
        TypedQuery<Cart> query = em.createQuery(sql, Cart.class).setParameter("q", quantity).setParameter("id", cartId);

        return true;
    }
}
