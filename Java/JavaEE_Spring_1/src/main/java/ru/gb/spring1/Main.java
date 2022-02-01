package ru.gb.spring1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
        Cart cart = context.getBean("cart", Cart.class);
        System.out.println(cart);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        System.out.println(productRepository);
        Product product = productRepository.findById(0);
        System.out.println(product.toString());
        productRepository.findByIdAll();
        System.out.println("=======================");
        Cart cart1 = context.getBean("cart", Cart.class);
        cart1.addToCart(3, productRepository);
        cart1.addToCart(2, productRepository);
        System.out.println(cart1);
        System.out.println(cart1.getProduct(0));
        System.out.println(cart1.getProduct(1));


        context.close();

    }
}
