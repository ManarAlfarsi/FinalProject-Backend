package com.example.demo.repository;

import com.example.demo.model.Candle;
import com.example.demo.model.Customer;
import com.example.demo.services.CandleService;
import com.example.demo.services.CustomerService;
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
class CustomerRepositoryTest {
    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerRepository customerRepository;
    @Test
    void findAll() {
        List<Customer> customerList = customerRepository.findAll();
        System.out.println(customerList);
        assertEquals(0, customerList.size());
    }
}