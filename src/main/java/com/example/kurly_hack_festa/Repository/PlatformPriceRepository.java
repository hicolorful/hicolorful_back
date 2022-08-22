package com.example.kurly_hack_festa.Repository;

import com.example.kurly_hack_festa.Entity.PlatformPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatformPriceRepository extends JpaRepository<PlatformPrice, Long> {
    List<PlatformPrice> findAllByProduct_id(Long productId);
}
