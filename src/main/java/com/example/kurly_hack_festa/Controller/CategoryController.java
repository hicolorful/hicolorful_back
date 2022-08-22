package com.example.kurly_hack_festa.Controller;

import com.example.kurly_hack_festa.Entity.Category;
import com.example.kurly_hack_festa.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("")
    public List<Category> getAllCategories() {
        return this.categoryService.getAllCategories();
    }
}
