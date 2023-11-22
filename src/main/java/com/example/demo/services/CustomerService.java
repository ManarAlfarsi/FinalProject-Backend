package com.example.demo.services;

import com.example.demo.DTO.JwtAuthenticationResponse;
import com.example.demo.model.Customer;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ManarAlfarsi
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return customerRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Autowired
    // private UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    // private final AuthenticationManager authenticationManager;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public JwtAuthenticationResponse createCustomer(Customer customer) {
        if (customer.getId() == null) {
            customer.setCreatedAt(LocalDateTime.now());
        }

        customer.setUpdatedAt(LocalDateTime.now());
        Customer user = Customer
                .builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .password(passwordEncoder.encode(customer.getPassword()))
                .role(Role.ROLE_CUSTOMER)
                .build();

        user = customerRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder()
                .token(jwt)
                .name(user.getName())
                .role(user.getRole().name())
                .email(user.getEmail())
                .build();
        // return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = getCustomerById(id);
        if (existingCustomer != null) {

            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        Customer existingCustomer = getCustomerById(id);
        if (existingCustomer != null) {
            customerRepository.delete(existingCustomer);
        }
    }

}
