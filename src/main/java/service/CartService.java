package service;

import entity.Cart;
import jakarta.transaction.Transactional;
import java.util.List;
import repository.CartRepository;

public class CartService {

    private final CartRepository cartRepository;

    public CartService() {
        cartRepository = new CartRepository();
    }

    public List<Cart> getCartListByUserId(int userId) {
        List<Cart> list = cartRepository.findCartListByUserId(userId);
        System.out.println(list);
        return list;
    }

    @Transactional
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Transactional
    public void saveAll(List<Cart> carts) {
        cartRepository.saveAll(carts);
    }
}
