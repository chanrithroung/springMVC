package com.springapp.springApplication.controllers;
import com.springapp.springApplication.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @GetMapping
    String redirect() {
        return "redirect:/dashboard";
    }

    @GetMapping( path = "/dashboard")
    String dashboard(Model model) {
        model.addAttribute("active", "dashboard");
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
        System.out.println(product);
        return "redirect:/dashboard";
    }
}
