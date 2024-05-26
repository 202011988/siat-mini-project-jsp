package service;

import entity.Cart;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import java.util.List;
import repository.CartRepository;

public class CartService {

    private final CartRepository cartRepository;

    public CartService() {
        cartRepository = new CartRepository();
    }

    public List<Cart> getCartListByUserId(String userId) {
        List<Cart> list = cartRepository.findCartListByUserId(userId);
        System.out.println(list);
        return list;
    }

    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    public void saveAll(List<Cart> carts) {
        cartRepository.saveAll(carts);
    }

    public void remove(Integer cartId) {
        cartRepository.removeAll(List.of(cartId));
    }

    public void removeAll(List<Integer> cartIds) {
        cartRepository.removeAll(cartIds);
    }

    public Integer updateQuantity(int cardId, int quantity) {
        return cartRepository.updateQuantity(cardId, quantity);
    }

    public Cart find(Integer id) {
        return cartRepository.findById(id);
    }

    public Cart findByUserIdAndProductId(String userId, Integer productId) {
        try {
            return cartRepository.findByUserIdAndProductId(userId, productId);
        } catch (NoResultException e) {
            return null;
        }
    }
}

