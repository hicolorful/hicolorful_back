package com.example.kurly_hack_festa.Repository;

import com.example.kurly_hack_festa.Entity.ReviewPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewPreferenceRepository extends JpaRepository<ReviewPreference, Long> {
    List<ReviewPreference> getAllByCategory_name(String categoryName);

    @Query(value = "SELECT min(price) FROM review_preference WHERE review_preference.category_id = :categoryId", nativeQuery = true)
    Integer getMinPrice(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT max(price) FROM review_preference WHERE review_preference.category_id = :categoryId", nativeQuery = true)
    Integer getMaxPrice(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT * FROM review_preference WHERE review_preference.category_id = :categoryId AND review_preference.price BETWEEN :maxPrice AND :minPrice", nativeQuery = true)
    List<ReviewPreference> getAllByUnit(@Param("categoryId") Long categoryId, @Param("maxPrice") Integer maxPrice, @Param("minPrice") Integer minPrice);
}
