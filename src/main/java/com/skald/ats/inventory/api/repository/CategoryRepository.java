package com.skald.ats.inventory.api.repository;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skald.ats.inventory.api.model.Category;

@Hidden
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}