package com.example.kurly_hack_festa.Repository;

import com.example.kurly_hack_festa.Entity.ProductCharacteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacteristicRepository extends JpaRepository<ProductCharacteristic, Long> {
    List<ProductCharacteristic> findAllByProduct_Category_name(String categoryName);

    @Query(value = "SELECT c.product_id, r.price FROM product_characteristic AS c INNER JOIN review_preference AS r WHERE c.product_id = r.product_id AND r.category_id = :categoryId", nativeQuery = true)
    List<List<Integer>> findAllPrice(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT * FROM product_characteristic AS c INNER JOIN review_preference AS r WHERE c.product_id = r.product_id AND r.category_id = :categoryId AND r.price >= :minPrice AND r.price < :maxPrice", nativeQuery = true)
    List<ProductCharacteristic> findAllByUnit(@Param("categoryId") Long categoryId, @Param("minPrice") Integer minPrice, @Param("maxPrice") Integer maxPrice);
}
