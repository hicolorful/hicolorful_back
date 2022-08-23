package com.example.kurly_hack_festa.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class FarmProducePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    private String produceName;

    private Date date;

    private Integer price;
}
