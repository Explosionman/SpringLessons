package ru.rybinskov.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rybinskov.gb.domain.Product;
import ru.rybinskov.gb.repository.DataInit;
import ru.rybinskov.gb.repository.ProductJpaDAO;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {

    private ProductJpaDAO productJpaDAO;

    @Autowired
    public void setProductJpaDAO(ProductJpaDAO productJpaDAO) {
        this.productJpaDAO = productJpaDAO;
        DataInit.init(productJpaDAO);
    }


    public ProductServiceImpl(ProductJpaDAO productJpaDAO) {
        this.productJpaDAO = productJpaDAO;
    }

    @Transactional
    public void save(Product product) {
        productJpaDAO.save(product);
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productJpaDAO.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        productJpaDAO.deleteById(id);
    }

    @Transactional
    public List<Product> getAll() {
        List<Product> products = productJpaDAO.findAll();
        products.sort(Comparator.comparingLong(Product::getId));
        return products;
    }

    @Transactional
    public List<Product> getAllFilteredByMinPrice() {
        List<Product> products = productJpaDAO.findAll();
        products.sort(Comparator.comparingLong(Product::getPrice));
        return products;
    }

    @Transactional
    public List<Product> getAllFilteredByMaxPrice() {
        List<Product> products = productJpaDAO.findAll();
        Comparator<Product> productComparator = Comparator.comparing(Product::getPrice);
        Collections.sort(products, productComparator.reversed());
        return products;
    }

    @Transactional
    public List<Product> getPriceByRange(Long start, Long end){
        List<Product> products = productJpaDAO.findAll();
        return products.stream()
                .filter(product-> product.getPrice() >= start && product.getPrice() <= end)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }
}
