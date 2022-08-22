package com.example.kurly_hack_festa.DTO;

import lombok.Data;

@Data
public class CompareResponseDto {
    private String platformName;
    private Integer price;
    private Integer gap;
    private Boolean isPlus;
}
