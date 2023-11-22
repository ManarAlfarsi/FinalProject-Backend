package com.example.demo.controller.impl;

import com.example.demo.controller.interfaces.ICandlesController;
import com.example.demo.model.Candle;
import com.example.demo.repository.CandleRepository;
import com.example.demo.services.CandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ManarAlfarsi
 */
@RestController
@RequestMapping("/api")
public class CandleController implements ICandlesController {

    @Autowired
    private CandleService candleService;


    @GetMapping("/candles")
    public List<Candle> listCandles() {
        return candleService.getAllCandles();
    }

    @GetMapping("/candles/{id}")
    public ResponseEntity<Candle> getCandleById(@PathVariable Long id) {
        Candle candle = candleService.getCandleById(id);
        if (candle != null) {
            return ResponseEntity.ok(candle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/candles")
    public ResponseEntity<Candle> createCandle(@RequestBody Candle candle) {
        Candle createdCandle = candleService.createCandle(candle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCandle);
    }


    @PutMapping("/candles/{id}")
    public ResponseEntity<Candle> updateCandle(@PathVariable Long id, @RequestBody Candle updatedCandle) {
        Candle updated = candleService.updateCandle(id, updatedCandle);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/candles/{id}")
    public ResponseEntity<Void> deleteCandle(@PathVariable Long id) {
        candleService.deleteCandle(id);
        return ResponseEntity.noContent().build();
    }

}


