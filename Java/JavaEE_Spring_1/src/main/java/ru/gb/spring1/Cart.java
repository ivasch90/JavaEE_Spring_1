package ru.gb.spring1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class Cart {
    private final ProductRepository productRepository;


    public Cart() {
        this.productRepository = new ProductRepository();
    }

    public void showCart() {
        if (productRepository.getProductList().size() != 0) {
            for (int j = 0; j < productRepository.getProductList().size(); j++) {
                System.out.println(productRepository.getProductList().get(j).toString());
            }
        }
        else {
            System.out.println("Корзина пуста");
        }
    }
    public void removeFromCart(int id) {
        for (int i = 0; i < productRepository.getProductList().size(); i++) {
            if (id == productRepository.getProductList().get(i).getId()) {
                productRepository.getProductList().remove(productRepository.getProductList().get(i));
            }
        }
    }

    public void addToCart(int id, ProductRepository productRepository1) {
        Product p1 = productRepository1.findById(id);
        productRepository.getProductList().add(p1);
    }
}
