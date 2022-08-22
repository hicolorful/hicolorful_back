package com.example.kurly_hack_festa.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class ReviewPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(columnDefinition = "Decimal (20, 16)")
    private Double pricePrefer;
}
