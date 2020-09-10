package ru.rybinskov.gb.service;

import org.springframework.stereotype.Service;
import ru.rybinskov.gb.domain.Product;
import ru.rybinskov.gb.repository.ProductRepoImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {

    private ProductRepoImpl productRepo;

    public ProductServiceImpl(ProductRepoImpl productRepo) {
        this.productRepo = productRepo;
    }

//    public Product getById(Long id){
//        return productRepo.getById(id);
//    }

    public List<Product> getAll(){
        List<Product> products = productRepo.getAll();
        products.sort(Comparator.comparingLong(Product::getId));
        return products;
    }

//    public Product save(Product product){
//        return productRepo.save(product);
//    }

    public void removeById(Long id){
        productRepo.remove(id);
    }
}
