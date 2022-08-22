package com.example.kurly_hack_festa.Service;

import com.example.kurly_hack_festa.Entity.Category;
import com.example.kurly_hack_festa.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }
}
