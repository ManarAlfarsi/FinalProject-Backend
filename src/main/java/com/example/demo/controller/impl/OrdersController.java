package com.example.demo.controller.impl;

import com.example.demo.DTO.CreateOrderDto;
import com.example.demo.controller.interfaces.IOrdersController;
import com.example.demo.model.Customer;
import com.example.demo.model.OrdersModel;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ManarAlfarsi
 */
@RestController
@RequestMapping("/api")
public class OrdersController implements IOrdersController {
    @Autowired
    private OrdersService orderService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/orders")
    public List<OrdersModel> listOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<OrdersModel> getOrderById(@PathVariable Long id) {
        OrdersModel order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<OrdersModel> createOrder(@RequestBody CreateOrderDto createOrderDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        OrdersModel order = createOrderDto.toOrder();
        Customer customer = customerRepository.findByEmail(userDetails.getUsername()).get();
        order.setCustomer(customer);
        OrdersModel createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<OrdersModel> updateOrder(@PathVariable Long id, @RequestBody OrdersModel updatedOrder) {
        OrdersModel updated = orderService.updateOrder(id, updatedOrder);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}
