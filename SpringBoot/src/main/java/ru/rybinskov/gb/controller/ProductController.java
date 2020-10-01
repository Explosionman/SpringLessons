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
                                  @RequestParam(name = "endPrice") Long endPrice) {
        List<Product> products = productService.getPriceByRange(startPrice, endPrice);
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/edit/{id}")
    public String getFormEditProduct(Model model, @PathVariable("id") Long id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editProduct(Model model, @PathVariable("id") Long id,
                              @RequestParam(name = "title") String title,
                              @RequestParam(name = "price") Integer price) {
        Product product = productService.findById(id);
        System.out.println("Получили: " + product.getTitle());
        product.setTitle(title);
        System.out.println("Получили: " + product.getTitle());
        product.setPrice(price);
        System.out.println("Получили: " + product.getPrice());
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/new")
    public String getFormNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";
    }


    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewProduct(Product product) {
        productService.save(product);
        return "redirect:/products/";
    }

}