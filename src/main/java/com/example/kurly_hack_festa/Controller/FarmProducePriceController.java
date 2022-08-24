package com.example.kurly_hack_festa.Controller;

import com.example.kurly_hack_festa.DTO.FarmProducePriceResponseDto;
import com.example.kurly_hack_festa.Service.FarmProducePriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("farm-price")
public class FarmProducePriceController {
    private final FarmProducePriceService farmProducePriceService;

    @GetMapping("")
    public List<FarmProducePriceResponseDto> getAllProducePrice(@RequestParam("category") String categoryName) {
        return this.farmProducePriceService.getAllProducePrice(categoryName);
    }
}
