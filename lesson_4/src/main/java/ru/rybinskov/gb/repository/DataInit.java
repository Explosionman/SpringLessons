package ru.rybinskov.gb.repository;

import ru.rybinskov.gb.domain.Product;

public class DataInit {
    public static void init(ProductJpaDAO productJpaDAO) {
        productJpaDAO.save(new Product("сыр", 550));
        productJpaDAO.save(new Product("лук", 10));
        productJpaDAO.save(new Product("чеснок", 10));
        productJpaDAO.save(new Product("колбаса", 800));
        productJpaDAO.save(new Product("хлеб", 35));
        productJpaDAO.save(new Product("молоко", 45));
        productJpaDAO.save(new Product("мороженое", 40));
        productJpaDAO.save(new Product("ветчина", 700));
        productJpaDAO.save(new Product("свинина", 400));
        productJpaDAO.save(new Product("говядина", 500));
        productJpaDAO.save(new Product("макароны", 60));
        productJpaDAO.save(new Product("гречка", 80));
    }
}
