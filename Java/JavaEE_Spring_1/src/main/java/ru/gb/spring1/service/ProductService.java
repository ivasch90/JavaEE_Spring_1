package ru.gb.spring1.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.spring1.entity.Product;
import ru.gb.spring1.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }



}
