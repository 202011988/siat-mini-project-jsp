package service;

import entity.Seller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Transient;
import java.util.List;

import repository.CartRepository;
import repository.SellerRepository;
import util.JPAUtil;

public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService() {
        sellerRepository = new SellerRepository();
    }



    @Transient
    public void save(Seller seller) {
        sellerRepository.save(seller);
    }

    @Transient
    public void saveAll(List<Seller> sellers) {
        sellerRepository.saveAll(sellers);
    }

    public Seller findSellerById(int sellerId) {
         return sellerRepository.findSellerById(sellerId);
    }

    public Seller findSellerByRegistrationNumberAndPassword(String registrationNumber,
            String password) {
        return sellerRepository.findSellerByRegistrationNumberAndPassword(registrationNumber, password);
    }

    public void off() {
        sellerRepository.off();
    }
}
