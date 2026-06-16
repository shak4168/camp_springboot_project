package com.example.young.repository;

import com.example.young.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByIsDeletedFalse();
    Optional<Product> findByIdAndIsDeletedFalse(Long id);
}