package com.skald.ats.inventory.api.controller;

import com.skald.ats.inventory.api.model.Product;
import com.skald.ats.inventory.api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

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

    @PostMapping( headers = "Content-Type=application/json")
    public ResponseEntity<Product> registerItem(@Valid @RequestBody Product product) {
        Product item = service.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(item);

    }

    @PutMapping(params = "id", headers = "Content-Type=application/json")
    public ResponseEntity<Product> updaEntity(@RequestParam Long id, @RequestBody Product product) {
        Product obj = service.update(id, product);
        return ResponseEntity.ok().body(obj);
    }
}
