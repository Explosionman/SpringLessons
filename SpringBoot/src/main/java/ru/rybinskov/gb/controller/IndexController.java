package ru.rybinskov.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "Скоро открытие!!! " +
                "А пока, взгляните на первый ассортимент: ");
        return "index";
    }
}
