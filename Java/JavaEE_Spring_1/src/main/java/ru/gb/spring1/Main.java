package ru.gb.spring1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.spring1.config.ProductConfig;
import ru.gb.spring1.repository.ProductRepository;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        Cart cart = context.getBean("cart", Cart.class);
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Введите команду: ");
            System.out.println("1 - состояние корзины");
            System.out.println("2 - добавить товар в корзину");
            System.out.println("3 - удалить товар из корзины");
            System.out.println();

            int i = scanner.nextInt();

            if (i == 1) {
                cart.showCart();
                System.out.println();
            } else if (i == 2) {
                System.out.println("Введите id товара: ");
                Scanner scanner1 = new Scanner(System.in);
                int idRepo = scanner1.nextInt();
                ProductRepository productRepository1 = context.getBean("productRepository", ProductRepository.class);
                cart.addToCart(idRepo, productRepository1);
                //System.out.println("Товар " + productRepository1.findById(idRepo).getName() + " добавлен в корзину!");
            } else if (i == 3) {
                System.out.println("Введите id товара: ");
                Scanner scanner1 = new Scanner(System.in);
                int idRepo = scanner1.nextInt();
                cart.removeFromCart(idRepo);
                System.out.println("Товар удален");
            } else {
                System.out.println("Ошибка! Товар не найден или неправильная команда");
                isTrue = false;
            }
        }

        context.close();
        scanner.close();
    }

}
