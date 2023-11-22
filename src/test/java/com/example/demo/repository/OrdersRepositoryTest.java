package com.example.demo.repository;

import com.example.demo.model.Candle;
import com.example.demo.model.OrdersModel;
import com.example.demo.services.CustomerService;
import com.example.demo.services.OrdersService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ManarAlfarsi
 */
@SpringBootTest
class OrdersRepositoryTest {
    @InjectMocks
    private OrdersService ordersService;
    @Mock
    private OrdersRepository ordersRepository;

    @Test
    void findAll() {
        List<OrdersModel> ordersList = ordersRepository.findAll();
        System.out.println(ordersList);
        assertEquals(0, ordersList.size());
    }
}