package com.example.kurly_hack_festa.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private Long reviewIndex;

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer price;

    @Column(columnDefinition = "TEXT")
    private String review;
}
