package com.skald.ats.inventory.api.controller;

import com.skald.ats.inventory.api.dto.ProductDTO;
import com.skald.ats.inventory.api.model.Product;
import com.skald.ats.inventory.api.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Produtos", description = "Gerenciamento de produtos")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Retorna todos os produtos")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = {"/{id}"})
    @Operation(summary = "Retorna um produto pelo ID")
    @Parameter(name = "id", description = "ID do produto", required = true)
    public ResponseEntity<Product> findItemByValue(@PathVariable Long id) {
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @Operation(summary = "Cadastra um novo produto")
    @PostMapping( headers = "Content-Type=application/json")
    public ResponseEntity<Product> registerItem(@Valid @RequestBody ProductDTO productDTO) {
        Product item = service.insertProduct(productDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(item);
    }

    @Operation(summary = "Atualiza dados do produto")
    @PutMapping(params = "id", headers = "Content-Type=application/json")
    public ResponseEntity<Product> updaEntity(@RequestParam Long id, @RequestBody Product product) {
        Product obj = service.update(id, product);
        return ResponseEntity.ok().body(obj);
    }
}
