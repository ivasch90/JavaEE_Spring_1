package ru.gb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
@ComponentScan("ru.gb")
public class ProductConfig {
    ProductRepository productRepository;

    @Value("false")
    private boolean isProductListFull;

    @Bean(name = "ProductRepository")
    public ProductRepository productList() {
        productRepository.init();

        return productRepository;
    }

    @Bean(name = "Cart")
    @Scope("prototype")
    public Cart cart () {
        return new Cart();
    }
}
