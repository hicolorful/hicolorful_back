package com.example.kurly_hack_festa.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class FarmProducePriceResponseDto {
    private String produceName;
    private Integer price;
    private Date date;
}
