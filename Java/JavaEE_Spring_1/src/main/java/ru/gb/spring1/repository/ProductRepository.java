package ru.gb.spring1.repository;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.gb.spring1.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Component
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();


    @PostConstruct
    public void init () {
        productList = new ArrayList<>();
        productList.add(new Product(0, "Apple", 100f));
        productList.add(new Product(1, "Meat", 500f));
        productList.add(new Product(2, "Lemon", 200f));
        productList.add(new Product(3, "Butter", 150f));
        productList.add(new Product(4, "Bread", 20f));
    }

    public Product save(Product product) {
        product.setId(productList.size());
        productList.add(product);

        return Product.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }

    public Optional<Product> findById(Integer id) {

        if (id < productList.size()) {
            return Optional.of(productList.get(id));
        }
        else {
            return Optional.empty();
        }
    }
    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }
}
