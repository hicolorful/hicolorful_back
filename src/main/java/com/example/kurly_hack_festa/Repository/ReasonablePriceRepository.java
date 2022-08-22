package com.example.kurly_hack_festa.Repository;
import com.example.kurly_hack_festa.Entity.ReviewReasonablePrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReasonablePriceRepository extends JpaRepository<ReviewReasonablePrice, Long> {
    ReviewReasonablePrice findByCategory_name(String categoryName);
}
