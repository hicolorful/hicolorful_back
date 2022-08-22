package com.example.kurly_hack_festa.Service;

import com.example.kurly_hack_festa.Entity.Product;
import com.example.kurly_hack_festa.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProductsByCategory(String categoryName) {
        return this.productRepository.findAllByCategory_name(categoryName);
    }
}
