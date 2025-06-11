package com.springapp.springApplication.controllers;
import com.springapp.springApplication.entity.Product;
import com.springapp.springApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    ProductRepository productRepository;

    @Autowired
    ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<Product> productList = new ArrayList<Product>();

    @GetMapping
    String redirect() {
        return "redirect:/dashboard";
    }

    @GetMapping( path = "/dashboard")
    String dashboard(Model model) {
        model.addAttribute("active", "dashboard");
        model.addAttribute("products", productRepository.findAll());
        return "dashboard";
    }

    @GetMapping(path = "/form")
    String form(Model model) {
        model.addAttribute("active", "form");
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping(path = "/submit")
    String submitProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        System.out.println(product);
        return "redirect:/dashboard";
    }
}
