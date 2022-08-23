package com.example.kurly_hack_festa.Service;

import com.example.kurly_hack_festa.DTO.ReviewPreferenceResponseDto;
import com.example.kurly_hack_festa.Entity.Category;
import com.example.kurly_hack_festa.Entity.ReviewPreference;
import com.example.kurly_hack_festa.Repository.CategoryRepository;
import com.example.kurly_hack_festa.Repository.ReviewPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewPreferenceService {
    private final ReviewPreferenceRepository reviewPreferenceRepository;
    private final CategoryRepository categoryRepository;

    public List<ReviewPreferenceResponseDto> getReviewPreference(String categoryName) {
//        List<ReviewPreference> preferences = this.reviewPreferenceRepository.getAllByCategory_name(categoryName);
        Category category = this.categoryRepository.getByName(categoryName);
        List<ReviewPreferenceResponseDto> res = new ArrayList<>();

        Integer minPrice = this.reviewPreferenceRepository.getMinPrice(category.getId());
        Integer maxPrice = this.reviewPreferenceRepository.getMaxPrice(category.getId());

        int unit = (maxPrice - minPrice) / 6;

        for (int i = 1; i < 8; i++) {
            ReviewPreferenceResponseDto responseDto = new ReviewPreferenceResponseDto();
            responseDto.setUnitPrice(minPrice);
            minPrice += unit;
            List<ReviewPreference> unitPreference = this.reviewPreferenceRepository.getAllByUnit(category.getId(), responseDto.getUnitPrice(), minPrice);

            double sum = 0;
            if (unitPreference.size() == 0) {
                responseDto.setUnitPrice(responseDto.getUnitPrice());
                responseDto.setPreference(0.0);
                res.add(responseDto);
                continue;
            }
            for (ReviewPreference reviewPreference : unitPreference) {
                sum += reviewPreference.getPricePrefer();
            }

            responseDto.setPreference(sum / unitPreference.size());

            res.add(responseDto);
        }

        return res;
    }
}
