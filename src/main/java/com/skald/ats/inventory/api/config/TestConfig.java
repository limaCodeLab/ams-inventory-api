package com.skald.ats.inventory.api.config;

import java.util.Arrays;

import com.skald.ats.inventory.api.config.environments.TestEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.skald.ats.inventory.api.model.entities.Category;
import com.skald.ats.inventory.api.model.entities.Product;
import com.skald.ats.inventory.api.repository.CategoryRepository;
import com.skald.ats.inventory.api.repository.ProductRepository;

@TestEnv
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat01 = new Category(null, "Peças de Motor");
        Category cat02 = new Category(null, "Sistema de Transmissão");
        Category cat03 = new Category(null, "Sistema de Freios");
        Category cat04 = new Category(null, "Suspensão e Direção");
        Category cat05 = new Category(null, "Sistema Elétrico");
        Category cat06 = new Category(null, "Sistema de Arrefecimento");
        Category cat07 = new Category(null, "Sistema de Exaustão");
        
        categoryRepository.saveAll(Arrays.asList(cat01, cat02, cat03, cat04, cat05, cat06, cat07));

        Product product01 = new Product(null,"Filtro de Óleo","Filtro de óleo para motor", 
        "Fornecedor A", "Filtros", 26.50,
        5, 100, "disponível", 20);

        Product product02 = new Product(null,"Bateria 12V","Bateria automotiva 12V 60Ah", 
        "Fornecedor C", "Baterias", 150.00,
        1, 5, "disponível", 10);

        productRepository.saveAll(Arrays.asList(product01, product02));

    }

}
