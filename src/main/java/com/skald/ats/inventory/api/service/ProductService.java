package com.skald.ats.inventory.api.service;

import com.skald.ats.inventory.api.dto.ProductDTO;
import com.skald.ats.inventory.api.exception.ResourceNotFoundException;
import com.skald.ats.inventory.api.model.Product;
import com.skald.ats.inventory.api.repository.ProductRepository;
import com.skald.ats.inventory.api.service.validations.DataProductValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    final ProductRepository repository;

    final ModelMapper modelMapper;

    final DataProductValidator dataValidation;

    @Autowired
    public ProductService(ProductRepository repository, ModelMapper modelMapper, DataProductValidator dataProductValidator) {
        this.modelMapper = modelMapper;
        this.repository = repository;
        this.dataValidation = dataProductValidator;
    }

    public Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
    @Transactional
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product insertProduct(ProductDTO productDTO) {
        dataValidation.productDataIsValid(productDTO);
        Product product = convertToEntity(productDTO);
        return saveProduct(product);
    }

    public List<Product> findAll() {
        return repository.findAllByOrderByIdAsc();
    }

    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.orElseThrow(() -> new ResourceNotFoundException(id));
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
//        entity.setName(product.getName());
//        entity.setDescription(product.getDescription());
//        entity.setSupplier(product.getSupplier());
//        entity.setCategory(product.getCategory());
//        entity.setUnitPrice(product.getUnitPrice());
//        entity.setMinimalStockLevel(product.getMinimalStockLevel());
//        entity.setMaximumStockLevel(product.getMaximumStockLevel());
//        entity.setStatus(product.getStatus());
    }


}
