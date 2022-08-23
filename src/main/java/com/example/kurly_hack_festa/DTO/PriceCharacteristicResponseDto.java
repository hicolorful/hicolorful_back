package com.example.kurly_hack_festa.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PriceCharacteristicResponseDto {
    private Integer unitPrice;
    private List<CharacteristicResponseDto> characteristicResponseDtos;
}
