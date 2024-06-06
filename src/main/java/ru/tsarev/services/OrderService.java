package ru.tsarev.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tsarev.entities.Order;
import ru.tsarev.entities.OrderItem;
import ru.tsarev.repositories.OrderItemRepository;
import ru.tsarev.repositories.OrderRepository;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    public Iterable<Order> getOrdersByUserId(long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }
}
