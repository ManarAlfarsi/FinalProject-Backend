package com.example.demo.repository;

import com.example.demo.model.Candle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * @ManarAlfarsi
 */
public interface CandleRepository extends JpaRepository<Candle, Long> {
    List<Candle> findAll();
}
