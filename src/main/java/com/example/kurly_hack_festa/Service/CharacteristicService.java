package com.example.kurly_hack_festa.Service;

import com.example.kurly_hack_festa.DTO.CharacteristicResponseDto;
import com.example.kurly_hack_festa.DTO.PriceCharacteristicResponseDto;
import com.example.kurly_hack_festa.Entity.Category;
import com.example.kurly_hack_festa.Entity.ProductCharacteristic;
import com.example.kurly_hack_festa.Exception.NoDateException;
import com.example.kurly_hack_festa.Repository.CategoryRepository;
import com.example.kurly_hack_festa.Repository.CharacteristicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacteristicService {
    private final CharacteristicRepository characteristicRepository;
    private final CategoryRepository categoryRepository;

    public List<PriceCharacteristicResponseDto> getPriceChar(String categoryName) {
        Category category = this.categoryRepository.getByName(categoryName);
        List<PriceCharacteristicResponseDto> res = new ArrayList<>();

        if (category == null) throw new NoDateException("해당 카테고리가 없습니다.");

        List<List<Integer>> prices = this.characteristicRepository.findAllPrice(category.getId());
        if (prices.size() == 0) throw new NoDateException("해당 카테고리에 데이터가 없습니다.");
        HashMap<Integer, Integer> priceMap = new HashMap<>();
        for (List<Integer> price: prices) {
            priceMap.put(price.get(0), price.get(1));
        }

        Integer minPrice = priceMap.values().stream().min(Integer::compare).get();
        Integer maxPrice = priceMap.values().stream().max(Integer::compare).get();

        int unit = (maxPrice - minPrice) / 6;

        for (int i = 1; i < 8; i ++) {
            PriceCharacteristicResponseDto responseDto = new PriceCharacteristicResponseDto();
            responseDto.setUnitPrice(minPrice);
            minPrice += unit;

            List<ProductCharacteristic> unitCharacteristic = this.characteristicRepository.findAllByUnit(category.getId(), responseDto.getUnitPrice(), minPrice);
            List<CharacteristicResponseDto> characteristicResponseDtos = new ArrayList<>();
            for (ProductCharacteristic characteristic: unitCharacteristic) {
                CharacteristicResponseDto characteristicResponseDto = new CharacteristicResponseDto();
                characteristicResponseDto.setCharacteristics(characteristic.getCharacteristic());
                characteristicResponseDto.setProductName(characteristic.getProduct().getName());
                characteristicResponseDtos.add(characteristicResponseDto);
            }
            responseDto.setCharacteristicResponseDtos(characteristicResponseDtos);

            res.add(responseDto);
        }

        return res;
    }
}
