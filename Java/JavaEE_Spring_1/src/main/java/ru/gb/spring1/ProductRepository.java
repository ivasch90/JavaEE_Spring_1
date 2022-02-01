package ru.gb.spring1;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class ProductRepository {
    private List<Product> productList;
    private Product product;

    @PostConstruct
    public void init () {
        productList = new ArrayList<>();
        productList.add(new Product(0, "Apple", 100f));
        productList.add(new Product(1, "Meat", 500f));
        productList.add(new Product(2, "Lemon", 200f));
        productList.add(new Product(3, "Butter", 150f));
        productList.add(new Product(4, "Bread", 20f));
    }

    public Product findById(int id) {

        product = productList.get(id);
        if (id == product.getId()) {
            System.out.println(product.getName());
        }
        return product;
    }
    public void findByIdAll() {
        for (int i = 0; i < productList.size(); i++) {
            Product product1 = productList.get(i);
            System.out.println(product1);
        }
    }
}
