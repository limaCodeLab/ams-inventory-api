package com.skald.ats.inventory.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skald.ats.inventory.api.model.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}