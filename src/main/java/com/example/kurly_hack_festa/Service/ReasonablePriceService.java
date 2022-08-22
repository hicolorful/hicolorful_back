package com.example.kurly_hack_festa.Service;

import com.example.kurly_hack_festa.DTO.ReasonablePriceResponseDto;
import com.example.kurly_hack_festa.Entity.ReviewReasonablePrice;
import com.example.kurly_hack_festa.Repository.ReasonablePriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReasonablePriceService {
    private final ReasonablePriceRepository reasonablePriceRepository;

    public ReasonablePriceResponseDto getReasonablePrice(String categoryName) {
        ReviewReasonablePrice reasonablePrice = this.reasonablePriceRepository.findByCategory_name(categoryName);

        ReasonablePriceResponseDto res = new ReasonablePriceResponseDto();
        res.setReasonablePrice(reasonablePrice.getReasonablePrice());

        return res;
    }
}
