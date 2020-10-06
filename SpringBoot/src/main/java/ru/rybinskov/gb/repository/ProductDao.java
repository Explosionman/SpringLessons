package ru.rybinskov.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rybinskov.gb.domain.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
}
