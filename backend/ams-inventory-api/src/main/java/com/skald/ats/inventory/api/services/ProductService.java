package com.skald.ats.inventory.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skald.ats.inventory.api.entities.Product;
import com.skald.ats.inventory.api.repositories.ProductRepository;
import com.skald.ats.inventory.api.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insert(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product product) {
        try {
            Product entity = repository.getReferenceById(id);
            updateProductData(entity, product);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
        
    }

    public void updateProductData(Product entity, Product product) {
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setSupplier(product.getSupplier());
        entity.setCategory(product.getCategory());
        entity.setCostPrice(product.getCostPrice());
        entity.setSalePrice(product.getSalePrice());
        entity.setQuantity(product.getQuantity());
        entity.setMinimalStockLevel(product.getMinimalStockLevel());
        entity.setMaximumStockLevel(product.getMaximumStockLevel());
        entity.setExpiryDate(product.getExpiryDate());
        entity.setStatus(product.getStatus());
        entity.setBarCode(product.getBarCode());
    }

}
