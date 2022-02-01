package ru.gb.spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("ru.gb.spring1")
public class ProductConfig {

    @Autowired
    public Cart cart (ProductRepository productRepository) {
        return new Cart(productRepository);
    }

}
