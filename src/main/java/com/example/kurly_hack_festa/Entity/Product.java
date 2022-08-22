package com.example.kurly_hack_festa.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(length = 20)
    private String name;
}
