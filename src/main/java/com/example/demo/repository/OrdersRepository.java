package com.example.demo.repository;

import com.example.demo.model.Candle;
import com.example.demo.model.OrdersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @ManarAlfarsi
 */
public interface OrdersRepository extends JpaRepository<OrdersModel, Long> {
    List<OrdersModel> findAll();
}
