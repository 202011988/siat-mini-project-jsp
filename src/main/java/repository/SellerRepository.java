package repository;

import entity.Seller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Transient;
import util.JPAUtil;

import java.util.List;

public class SellerRepository {

    EntityManager em;
    EntityTransaction tx;

    public SellerRepository() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Transient
    public void save(Seller seller) {
        em.persist(seller);

        tx.commit();
    }

    public void saveAll(List<Seller> sellers) {
        for (Seller seller : sellers) {
            em.persist(seller);
        }
        tx.commit();
    }

    public Seller findSellerById(int sellerId) {
        return em.find(Seller.class, sellerId);
    }

    public Seller findSellerByRegistrationNumberAndPassword(String registrationNumber, String password) {
        String sql = "SELECT s FROM Seller s WHERE s.registrationNumber = :id AND s.password = :pw";
        Seller seller = null;
        try {
            seller = em.createQuery(sql, Seller.class)
                    .setParameter("id", registrationNumber)
                    .setParameter("pw", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return seller;
    }

    public void off() {
        em.close();
    }
}
