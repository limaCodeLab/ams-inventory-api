package com.skald.ats.inventory.api.repository;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skald.ats.inventory.api.model.Product;

import java.util.List;

@Hidden
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findAllByOrderByIdAsc();
}
