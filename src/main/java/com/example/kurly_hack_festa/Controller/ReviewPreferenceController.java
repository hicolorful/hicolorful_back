package com.example.kurly_hack_festa.Controller;

import com.example.kurly_hack_festa.DTO.ReviewPreferenceResponseDto;
import com.example.kurly_hack_festa.Service.ReviewPreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/preference")
public class ReviewPreferenceController {
    private final ReviewPreferenceService reviewPreferenceService;

    @GetMapping("")
    public List<ReviewPreferenceResponseDto> getReviewPreference(@RequestParam("category") String categoryName) {
        return this.reviewPreferenceService.getReviewPreference(categoryName);
    }
}
