package com.example.demo.services;

import com.example.demo.model.Candle;
import com.example.demo.repository.CandleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ManarAlfarsi
 */
@Service
public class CandleService {
    @Autowired
    private CandleRepository candleRepository;

    public List<Candle> getAllCandles() {
        return candleRepository.findAll();
    }

    public Candle getCandleById(Long id) {
        return candleRepository.findById(id).orElse(null);
    }

    public Candle createCandle(Candle candle) {
        return candleRepository.save(candle);
    }

    public Candle updateCandle(Long id, Candle updatedCandle) {
        Candle existingCandle = getCandleById(id);
        if (existingCandle != null) {

            existingCandle.setName(updatedCandle.getName());
            existingCandle.setDescription(updatedCandle.getDescription());
            existingCandle.setPrice(updatedCandle.getPrice());
            return candleRepository.save(existingCandle);
        }
        return null;
    }

    public void deleteCandle(Long id) {
        Candle existingCandle = getCandleById(id);
        if (existingCandle != null) {
            candleRepository.delete(existingCandle);
        }
    }


}
