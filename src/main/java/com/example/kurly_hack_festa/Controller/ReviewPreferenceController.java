package com.example.kurly_hack_festa.Controller;

import com.example.kurly_hack_festa.DTO.ReviewPreferenceResponseDto;
import com.example.kurly_hack_festa.Exception.NoDateException;
import com.example.kurly_hack_festa.Service.ReviewPreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler(NoDateException.class)
    public ResponseEntity<String> handleNoDataException(NoDateException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
