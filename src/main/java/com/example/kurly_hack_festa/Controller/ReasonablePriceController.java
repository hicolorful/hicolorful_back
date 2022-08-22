package com.example.kurly_hack_festa.Controller;

import com.example.kurly_hack_festa.DTO.ReasonablePriceResponseDto;
import com.example.kurly_hack_festa.Service.ReasonablePriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reasonable-price")
public class ReasonablePriceController {
    private final ReasonablePriceService reasonablePriceService;

    // 리뷰별 적정가 얻기
    @GetMapping("")
    public ReasonablePriceResponseDto getReasonablePrice(@RequestParam("category") String categoryName) {
        return this.reasonablePriceService.getReasonablePrice(categoryName);
    }
}
