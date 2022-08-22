package com.example.kurly_hack_festa.Controller;

import com.example.kurly_hack_festa.DTO.CompareResponseDto;
import com.example.kurly_hack_festa.Service.CompareService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compare")
public class CompareController {
    private final CompareService compareService;

    @GetMapping("/{productId}")
    public List<CompareResponseDto> getCompare(@PathVariable("productId") Long productId) {
        return this.compareService.getCompare(productId);
    }
}
