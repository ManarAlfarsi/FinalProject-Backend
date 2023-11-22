package com.example.demo.controller.impl;

import com.example.demo.DTO.JwtAuthenticationResponse;
import com.example.demo.DTO.SignInRequest;
import com.example.demo.DTO.SignUpRequest;
import com.example.demo.controller.interfaces.ICustomerController;
import com.example.demo.model.Customer;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.AuthenticationService;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * @ManarAlfarsi
 */
@RestController
@RequestMapping("/api")
public class CustomerController implements ICustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AuthenticationService authService;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> listCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public JwtAuthenticationResponse saveCustomer(@RequestBody @Valid SignUpRequest customer) {
        return customerService.createCustomer(customer.toCustomer());
        // authService.signup(customer, Role.ROLE_CUSTOMER);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        Customer updated = customerService.updateCustomer(id, updatedCustomer);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
