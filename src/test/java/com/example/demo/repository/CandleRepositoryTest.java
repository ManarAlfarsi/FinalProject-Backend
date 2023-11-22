package com.example.demo.repository;

import com.example.demo.model.Candle;
import com.example.demo.services.CandleService;
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
class CandleRepositoryTest {
    @InjectMocks
    private CandleService candleService;

    @Mock
    private CandleRepository candleRepository;
    @Test
    void findAll() {
        List<Candle> candleList = candleRepository.findAll();
        System.out.println(candleList);
        assertEquals(0, candleList.size());
    }
}