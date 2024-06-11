package com.skald.ats.inventory.api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.skald.ats.inventory.api.entities.Product;
import com.skald.ats.inventory.api.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Product product01 = new Product(null,"Filtro de Óleo","Filtro de óleo para motor", 
        "Fornecedor A", "Filtros", 10.00, 15.00, 50, 
        5, 100, Instant.parse("2019-06-20T19:53:07Z"), 
        Instant.parse("2024-07-22T15:21:22Z"), "disponível", "1234567890123");

        Product product02 = new Product(null,"Bateria 12V","Bateria automotiva 12V 60Ah", 
        "Fornecedor C", "Baterias", 150.00, 305.00, 20, 
        5, 50, Instant.parse("2019-06-20T19:53:07Z"), 
        Instant.parse("2024-07-22T15:21:22Z"), "disponível", "1234567890523");

        productRepository.saveAll(Arrays.asList(product01, product02));

    }

}
