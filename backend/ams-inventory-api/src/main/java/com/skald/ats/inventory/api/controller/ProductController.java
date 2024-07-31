package com.skald.ats.inventory.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.skald.ats.inventory.api.model.entities.Product;
import com.skald.ats.inventory.api.service.ProductService;

@RestController
@RequestMapping("/inventory/api/items")
public class ProductController {

    @Autowired
    private ProductService service;
    
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Product> findItemByValue(@PathVariable Long id) {
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping(params = "id")
    public ResponseEntity<Product> findByIdParam(@RequestParam Long id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/register", headers = "Content-Type=application/json")
    public ResponseEntity<Product> registerItem(@RequestBody Product product) {
        product =service.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(product);
    }

    @PutMapping(value = "/update", params = "id", headers = "Content-Type=application/json")
    public ResponseEntity<Product> updaEntity(@RequestParam Long id, @RequestBody Product product) {
        Product obj = service.update(id, product);
        return ResponseEntity.ok().body(obj);
    }

}
