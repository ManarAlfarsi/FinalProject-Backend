package com.example.demo.services;

import com.example.demo.model.OrdersModel;
import com.example.demo.model.User;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.UserRepository;

// import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ManarAlfarsi
 */
@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public List<OrdersModel> getAllOrders() {
        return ordersRepository.findAll();
    }

    public OrdersModel getOrderById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public OrdersModel createOrder(OrdersModel orders) {
        // User user = userRepository.findByEmail();
        return ordersRepository.save(orders);
    }

    public OrdersModel updateOrder(Long id, OrdersModel updatedOrder) {
        OrdersModel existingOrder = getOrderById(id);
        if (existingOrder != null) {

            existingOrder.setCustomer(updatedOrder.getCustomer());
            existingOrder.setCandles(updatedOrder.getCandles());
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            return ordersRepository.save(existingOrder);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        OrdersModel existingOrder = getOrderById(id);
        if (existingOrder != null) {
            ordersRepository.delete(existingOrder);
        }
    }

}
