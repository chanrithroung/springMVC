package com.springapp.springApplication.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/admin")
public class StudentViewControllers {

    List<String> names = new ArrayList<>(
            List.of("MentJs", "LeapKeio", "TaiNuth", "Setha", "LeangSim")
    );

    @GetMapping(path = "/{name}")
    String homePage(@PathVariable String name, Model model) {
        model.addAttribute("names", names);
        return "home";
    }
}
