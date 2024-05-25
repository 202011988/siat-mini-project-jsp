package service;

import entity.Order;
import repository.OrderRepository;

public class OrderService {

    private OrderRepository orderRepository;

    public OrderService() {
        orderRepository = new OrderRepository();
    }

    public void save(Order order) {
        orderRepository.save(order);
    }
}
