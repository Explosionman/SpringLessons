package ru.rybinskov.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rybinskov.gb.domain.Product;

import java.util.List;

public interface ProductJpaDAO extends JpaRepository<Product, Long> {

}
