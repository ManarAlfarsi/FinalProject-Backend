package com.example.demo.controller.impl;

import com.example.demo.model.OrdersModel;
import com.example.demo.services.OrdersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ManarAlfarsi
 */
class OrdersControllerTest {
    @InjectMocks
    private OrdersController ordersController;

    @Mock
    private OrdersService ordersService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    // ****put test****
    @Test
    public void testUpdateOrder() {
        Long orderId = 1L;
        OrdersModel updatedOrder = new OrdersModel();
        updatedOrder.setId(orderId);

        Mockito.when(ordersService.updateOrder(orderId, updatedOrder)).thenReturn(updatedOrder);

        ResponseEntity<OrdersModel> responseEntity = ordersController.updateOrder(orderId, updatedOrder);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedOrder, responseEntity.getBody());
    }

    @Test
    public void testUpdateOrderNotFound() {

        Long orderId = 1L;
        OrdersModel updatedOrder = new OrdersModel();
        updatedOrder.setId(orderId);

        Mockito.when(ordersService.updateOrder(orderId, updatedOrder)).thenReturn(null);

        ResponseEntity<OrdersModel> responseEntity = ordersController.updateOrder(orderId, updatedOrder);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}