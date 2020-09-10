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

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String getById(Model model,@PathVariable("id") Long id){
//        Product byId = productService.getById(id);
//        model.addAttribute("product",
//                byId == null ? new Product(): byId);
//        return "product";
//    }

//    @RequestMapping(value = "/{id}/price", method = RequestMethod.GET)
//    @ResponseBody
//    public String apiPrice(@PathVariable Long id){
//        Product byId = productService.getById(id);
//        return String.valueOf(byId == null ? null : byId.getPrice());
//    }

    @GetMapping("/new")
    public String getFormNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model, @PathVariable("id") Long id) {
        productService.removeById(id);
        return "redirect:/products";
    }

//    @RequestMapping(value = "/new", method = RequestMethod.POST)
//    public String addNewProduct(Product product){
//        Product savedProduct = productService.save(product);
//        System.out.println(savedProduct);
//        return "redirect:/products/" + savedProduct.getId();
//    }
}