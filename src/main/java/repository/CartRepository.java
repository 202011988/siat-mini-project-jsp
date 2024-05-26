package repository;

import entity.Cart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
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

    public List<Cart> findCartListByUserId(String userId) {
        String sql = "SELECT c FROM Cart c WHERE c.user.id = :userId";
        TypedQuery<Cart> query = em.createQuery(sql, Cart.class).setParameter("userId", userId);

//        off();
        return query.getResultList();
    }

    private void off() {
        em.close();
    }

    public void saveAll(List<Cart> carts) {
        for (Cart cart : carts) {
            em.persist(cart);
        }
        tx.commit();
    }

    public void removeAll(List<Integer> cartIds) {
        int result;
        for (Integer id : cartIds) {
            String sql = "DELETE FROM Cart c WHERE c.id = :id";
            result = em.createQuery(sql).setParameter("id", id).executeUpdate();
            if (result != 1) {
                return;
            }
        }

        tx.commit();
    }

    public Integer updateQuantity(int cartId, int quantity) {
        String sql = "UPDATE Cart c set c.quantity = :q where c.id = :id";
        Integer result = em.createQuery(sql).setParameter("q", quantity)
                .setParameter("id", cartId).executeUpdate();

        tx.commit();
        return result;
    }

    public Cart findById(Integer id) {
        String sql = "SELECT c FROM Cart c WHERE c.id = :id";
        return em.createQuery(sql, Cart.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
