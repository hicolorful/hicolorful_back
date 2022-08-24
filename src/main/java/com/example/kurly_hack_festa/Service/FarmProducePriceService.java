package com.example.kurly_hack_festa.Service;

import com.example.kurly_hack_festa.DTO.FarmProducePriceResponseDto;
import com.example.kurly_hack_festa.Entity.Category;
import com.example.kurly_hack_festa.Entity.FarmProducePrice;
import com.example.kurly_hack_festa.Repository.CategoryRepository;
import com.example.kurly_hack_festa.Repository.FarmProducePriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmProducePriceService {
    private final FarmProducePriceRepository farmProducePriceRepository;
    private final CategoryRepository categoryRepository;

    public List<FarmProducePriceResponseDto> getAllProducePrice(String categoryName) {
        List<FarmProducePriceResponseDto> res = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        int pastMonth = calendar.get(Calendar.MONTH) + 1;
        calendar.add(Calendar.MONTH, +4);
        int futureMonth = calendar.get(Calendar.MONTH) + 1;

        Category category = this.categoryRepository.getByName(categoryName);
        List<FarmProducePrice> farmProducePrices = this.farmProducePriceRepository.getAllByDate(category.getId(), pastMonth, futureMonth);

        for (FarmProducePrice farmProducePrice: farmProducePrices) {
            FarmProducePriceResponseDto farmProducePriceResponseDto = new FarmProducePriceResponseDto();
            farmProducePriceResponseDto.setPrice(farmProducePrice.getPrice());
            farmProducePriceResponseDto.setProduceName(farmProducePrice.getProduceName());
            farmProducePriceResponseDto.setDate(farmProducePrice.getDate());
            res.add(farmProducePriceResponseDto);
        }

        return res;
    }
}
