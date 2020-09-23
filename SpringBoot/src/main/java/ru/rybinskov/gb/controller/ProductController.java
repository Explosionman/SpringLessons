package ru.rybinskov.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rybinskov.gb.domain.Product;
import ru.rybinskov.gb.service.ProductServiceImpl;

import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model, @PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/filterByMin")
    public String filterByMin(Model model) {
        List<Product> products = productService.getAllFilteredByMinPrice();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/filterByMax")
    public String filterByMax(Model model) {
        List<Product> products = productService.getAllFilteredByMaxPrice();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/filterById")
    public String filterById(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping(params = {"startPrice", "endPrice"})
    public String productsByPrice(Model model,
                                  @RequestParam(name = "startPrice") Long startPrice,
                                  @RequestParam(name = "endPrice") Long endPrice){
        List<Product> products = productService.getPriceByRange(startPrice, endPrice);
        model.addAttribute("products", products);
        return "products";
    }

}