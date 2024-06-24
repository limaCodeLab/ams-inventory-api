package com.skald.ats.inventory.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skald.ats.inventory.api.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}