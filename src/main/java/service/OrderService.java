package service;

import entity.Order;
import java.util.List;
import repository.OrderRepository;

public class OrderService {

    private OrderRepository orderRepository;

    public OrderService() {
        orderRepository = new OrderRepository();
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void saveAll(List<Order> orders) {
        orderRepository.saveAll(orders);
    }

    public List<Order> findAllByUserId(String userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public Order findById(int orderId) {
        return orderRepository.find(orderId);
    }
}
