package ru.gb;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Scope("Prototype")
public class Cart {
    int index;
    private ProductRepository productRepository;


    public Cart() {
        index = 0;
    }

    public void addToCart(int id, ProductRepository productRepository) {
        Product product = productRepository.getProductList().get(id);
        this.productRepository.getProductList().add(index, product);
        index++;
    }

    public void removeFromCart (int id, ProductRepository productRepository) {
        Product product = (Product) productRepository.findById(id);
    }
}
