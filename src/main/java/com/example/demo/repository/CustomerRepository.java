package com.example.demo.repository;

// import com.example.demo.model.Candle;
import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @ManarAlfarsi
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAll();

    Optional<Customer> findByEmail(String email);
}
