package com.example.kurly_hack_festa.Controller;

import com.example.kurly_hack_festa.Entity.Product;
import com.example.kurly_hack_festa.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public List<Product> getProductByCategory(@RequestParam("category") String categoryName) {
        return this.productService.getProductsByCategory(categoryName);
    }
}
