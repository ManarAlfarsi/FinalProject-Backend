package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/*
 * @ManarAlfarsi
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Candle> candles;

    private Date orderDate;

    // public Orders() {
    // }

    // public Orders(Customer customer, List<Candle> candles, Date orderDate) {
    // this.customer = customer;
    // this.candles = candles;
    // this.orderDate = orderDate;
    // }

    // public Long getId() {
    // return id;
    // }

    // public void setId(Long id) {
    // this.id = id;
    // }

    // public Customer getCustomer() {
    // return customer;
    // }

    // public void setCustomer(Customer customer) {
    // this.customer = customer;
    // }

    // public List<Candle> getCandles() {
    // return candles;
    // }

    // public void setCandles(List<Candle> candles) {
    // this.candles = candles;
    // }

    // public Date getOrderDate() {
    // return orderDate;
    // }

    // public void setOrderDate(Date orderDate) {
    // this.orderDate = orderDate;
    // }

    // @Override
    // public String toString() {
    // return "Orders{" +
    // "id=" + id +
    // ", customer=" + customer +
    // ", candles=" + candles +
    // ", orderDate=" + orderDate +
    // '}';
    // }
    public double getTotalPrice() {
        return candles.stream().mapToDouble(Candle::getPrice).sum();
    }

}
