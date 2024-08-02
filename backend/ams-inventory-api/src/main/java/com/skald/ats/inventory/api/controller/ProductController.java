package com.skald.ats.inventory.api.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skald.ats.inventory.api.service.exceptions.NotificationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.skald.ats.inventory.api.model.entities.Product;
import com.skald.ats.inventory.api.service.ProductService;

@RestController
@RequestMapping("/api/products")
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
    public ResponseEntity<Product> registerItem(@Valid @RequestBody Product product) {
        Product item = service.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(item);

    }

    @PutMapping(value = "/update", params = "id", headers = "Content-Type=application/json")
    public ResponseEntity<Product> updaEntity(@RequestParam Long id, @RequestBody Product product) {
        Product obj = service.update(id, product);
        return ResponseEntity.ok().body(obj);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((FieldError error) ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.unprocessableEntity().body(errors);
    }

}
