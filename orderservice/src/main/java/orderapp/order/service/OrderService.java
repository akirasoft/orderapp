package orderapp.order.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import orderapp.model.Order;

@Service
public class OrderService {
	
	int i = 0;
	
	private Map<Integer, Order> orders = new HashMap<Integer, Order>();

	public Order getOrder(int id) {
		return orders.get(id);
	}
	
	public int createOrder(Order order) {
		int id = i++ % 25;
		order.setId(id);
		orders.put(id, order);
		return id;
	}
}
