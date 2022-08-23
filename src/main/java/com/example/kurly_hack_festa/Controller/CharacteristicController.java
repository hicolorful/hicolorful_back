package com.example.kurly_hack_festa.Controller;

import com.example.kurly_hack_festa.DTO.PriceCharacteristicResponseDto;
import com.example.kurly_hack_festa.Exception.NoDateException;
import com.example.kurly_hack_festa.Service.CharacteristicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
public class CharacteristicController {
    private final CharacteristicService characteristicService;

    @GetMapping("")
    public List<PriceCharacteristicResponseDto> getPriceChar(@RequestParam("category") String categoryName) {
        return this.characteristicService.getPriceChar(categoryName);
    }


    @ExceptionHandler(NoDateException.class)
    public ResponseEntity<String> handleNoDataException(NoDateException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
