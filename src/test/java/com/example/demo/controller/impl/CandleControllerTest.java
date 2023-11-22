package com.example.demo.controller.impl;

import com.example.demo.model.Candle;
import com.example.demo.repository.CandleRepository;
import com.example.demo.services.CandleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @ManarAlfarsi
 */
@SpringBootTest
class CandleControllerTest {
    @Mock
    private CandleService candleService;

    @InjectMocks
    private CandleController candleController;

    //****delete test****
    @Test
    void deleteCandle() {
        Long candleId = 1L;
        Mockito.doNothing().when(candleService).deleteCandle(candleId);
        ResponseEntity<Void> responseEntity = candleController.deleteCandle(candleId);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}






