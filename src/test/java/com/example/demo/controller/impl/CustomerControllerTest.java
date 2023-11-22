package com.example.demo.controller.impl;

import com.example.demo.DTO.JwtAuthenticationResponse;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.delete;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ManarAlfarsi
 */
@SpringBootTest
class CustomerControllerTest {
    @InjectMocks
    private CustomerController customerController;

    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerRepository customerRepository;
    Customer customer;

    // ****get test****
    @Test
    public void ListCustomersTest() {
        List<Customer> expectedCustomers = Arrays.asList(
                Customer.builder().name("Manar").email("M@gmail.com").build(),
                Customer.builder().name("Amal").email("A@gmail.com").build());
        when(customerService.getAllCustomers()).thenReturn(expectedCustomers);

        List<Customer> actualCustomers = customerController.listCustomers();

        assertEquals(expectedCustomers, actualCustomers);
    }

    // ****post test****
    @Test
    void createCustomerTest() {
        Customer newCustomer = new Customer();
        newCustomer.setName("Manar Alfarsi");
        newCustomer.setEmail("MA@gmail.com");

        Mockito.when(customerRepository.save(newCustomer)).thenReturn(newCustomer);

        JwtAuthenticationResponse createdCustomer = customerService.createCustomer(newCustomer);

        Assertions.assertEquals("Manar Alfarsi", createdCustomer.getName());
        Assertions.assertEquals("MA@gmail.com", createdCustomer.getEmail());

    }

}
