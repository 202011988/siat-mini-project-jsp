package service;

import entity.Category;
import entity.Seller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import java.util.List;
import util.JPAUtil;

public class SellerService {

    EntityManager em;
    EntityTransaction tx;

    public SellerService() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Transactional
    public void save(Seller seller) {
        em.persist(seller);
        tx.commit();
    }

    @Transactional
    public void saveAll(List<Seller> sellers) {
        for (Seller seller : sellers) {
            em.persist(seller);
        }
        tx.commit();
    }

    public void off() {
        em.close();
    }
}
