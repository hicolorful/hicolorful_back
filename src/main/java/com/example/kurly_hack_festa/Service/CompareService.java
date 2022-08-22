package com.example.kurly_hack_festa.Service;

import com.example.kurly_hack_festa.DTO.CompareResponseDto;
import com.example.kurly_hack_festa.Entity.PlatformPrice;
import com.example.kurly_hack_festa.Entity.Product;
import com.example.kurly_hack_festa.Entity.ReviewReasonablePrice;
import com.example.kurly_hack_festa.Repository.PlatformPriceRepository;
import com.example.kurly_hack_festa.Repository.ReasonablePriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompareService {
    private final PlatformPriceRepository platformPriceRepository;
    private final ReasonablePriceRepository reasonablePriceRepository;

    public List<CompareResponseDto> getCompare(Long productId) {
        List<CompareResponseDto> res = new ArrayList<>();
        List<PlatformPrice> platformPrices = this.platformPriceRepository.findAllByProduct_id(productId);

        if (platformPrices.size() == 0) {
            // TODO: 에러처리? Kurly Only 표시?
            return res;
        }

        Product product = platformPrices.get(0).getProduct();
        ReviewReasonablePrice reasonablePrice = this.reasonablePriceRepository.findByCategory_name(product.getCategory().getName());

        platformPrices.forEach(platformPrice -> {
            CompareResponseDto responseDto = new CompareResponseDto();
            responseDto.setPlatformName(platformPrice.getPlatformName());
            responseDto.setPrice(platformPrice.getPrice());

            int gap = (int) ((int) platformPrice.getPrice() - reasonablePrice.getReasonablePrice());
            responseDto.setGap(Math.abs(gap));
            responseDto.setIsPlus(gap > 0);

            res.add(responseDto);
        });

        return res;
    }
}
