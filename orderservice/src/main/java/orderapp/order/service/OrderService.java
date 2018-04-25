package orderapp.order.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import orderapp.model.Order;
import orderapp.order.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> findOrderById(Long orderId) {
        return Optional.ofNullable(orderRepository.findById(orderId))
            .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + orderId));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Order createOrder(Order order) {
        final Order newOrder = new Order();
        newOrder.setAccountId(order.getAccountId());
        newOrder.setProductId(order.getProductId());
        return orderRepository.save(newOrder);
    }
}

