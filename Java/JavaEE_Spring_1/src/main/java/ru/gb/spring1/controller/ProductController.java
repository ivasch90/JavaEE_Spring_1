package ru.gb.spring1.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.spring1.entity.Product;
import ru.gb.spring1.service.ProductService;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

        @RequestMapping(path = "/create", method = RequestMethod.GET)
        public String ShowForm (Model model) {
            Product product = new Product();
            model.addAttribute("product", product);
            return "create-product";

        }

        @RequestMapping(path = "/create", method = RequestMethod.POST)
        public String processForm(Product product) {
            if (product.getId() == null) {
                productService.save(product);
            }
            return "redirect:/products/all";
        }

        @RequestMapping(path = "/all", method = RequestMethod.GET)
        public String getAllProduct(Model model) {
            model.addAttribute("productList", productService.findAll());
            return "products";
        }
}
