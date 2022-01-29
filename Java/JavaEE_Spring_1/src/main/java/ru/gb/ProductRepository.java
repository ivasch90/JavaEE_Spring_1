package ru.gb;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Getter
@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init () {
        productList.add(new Product(1, "Apple", 100f));
        productList.add(new Product(2, "Meat", 500f));
        productList.add(new Product(3, "Lemon", 200f));
        productList.add(new Product(4, "Butter", 150f));
        productList.add(new Product(5, "Bread", 20f));
    }

    public Object findById(int id) {
        String productName = "";
        if (id == productList.get(id).getId()) {
                productName = productList.get(id).getName();
                System.out.println(productName);
                return productList.get(id);
            }
        return Optional.empty();
    }
    public String findByIdAll() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < productList.size(); i++) {
            String name = productList.get(i).getName();
            sb.append(name);
            sb.append("\\n");
        }
        return sb.toString();
    }
}
