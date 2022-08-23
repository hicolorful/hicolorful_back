package com.example.kurly_hack_festa.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class ProductCharacteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;

    private String characteristic;
}
