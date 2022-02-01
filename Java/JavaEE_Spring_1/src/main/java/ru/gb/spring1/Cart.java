package ru.gb.spring1;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class Cart {
    private int index;
    private ProductRepository productRepository;
    private Product product;


    //public Cart() {
    //    index = 0;
    //}

    public Cart(ProductRepository productRepository) {
        index = 0;
        this.productRepository = productRepository;
    }

    public void addToCart(int id, ProductRepository productRepository) {
        product = productRepository.getProductList().get(id);
        this.productRepository.getProductList().add(index, product);
        index++;
    }

    public void removeFromCart (int id) {
        product = productRepository.findById(id);
        if (product != null) {

        }
    }

    public Product getProduct (int id) {
        Product product1 = productRepository.findById(id);
        return product1;
    }
}
