package com.example.kurly_hack_festa.Repository;

import com.example.kurly_hack_festa.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getByName(String categoryName);
}
