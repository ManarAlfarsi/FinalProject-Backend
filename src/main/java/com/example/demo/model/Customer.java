package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
// import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @ManarAlfarsi
 */
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrdersModel> orders;
    // @OneToMany
    // private String name;
    // private String email;

}
