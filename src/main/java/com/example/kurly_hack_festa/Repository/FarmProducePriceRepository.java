package com.example.kurly_hack_festa.Repository;

import com.example.kurly_hack_festa.Entity.FarmProducePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FarmProducePriceRepository extends JpaRepository<FarmProducePrice, Long> {
    List<FarmProducePrice> getAllByCategory_name(String categoryName);

    @Query(value = "SELECT * FROM farm_produce_price AS f WHERE f.category_id = :categoryId AND MONTH(f.date) BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<FarmProducePrice> getAllByDate(@Param("categoryId") Long categoryId, @Param("startDate") int startDate, @Param("endDate") int endDate);
}
