package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.example.demo.model.Candle;
import com.example.demo.model.OrdersModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {
    // private String customerEmail;
    private List<Candle> candles;

    public OrdersModel toOrder() {
        OrdersModel order = new OrdersModel();
        // List<Candle> orderCandles = List.of();
        // var iterator = candles.iterator();
        // while (iterator.hasNext()) {
        // orderCandles.add(Candle.builder()
        // .id(iterator.next()).build());
        // }
        order.setCandles(candles);
        order.setOrderDate(new Date());
        return order;
    }
}
