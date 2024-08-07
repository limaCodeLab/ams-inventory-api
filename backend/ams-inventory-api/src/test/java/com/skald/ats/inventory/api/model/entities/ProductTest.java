package com.skald.ats.inventory.api.model.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {

    @Test
    void crianEntidadeProduto() {
        Product product =  new Product(null,"Filtro de Óleo","Filtro de óleo para motor",
                "Fornecedor A", "Filtros", 26.50,
                5, 100, "disponível");

        assertEquals(null, product.getId());
        assertEquals("Filtro de Óleo", product.getName());
        assertEquals("Filtro de óleo para motor", product.getDescription());
        assertEquals("Fornecedor A", product.getSupplier());
        assertEquals("Filtros", product.getCategory());
        assertEquals(26.50, product.getUnitPrice());
        assertEquals(5, product.getMinimalStockLevel());
        assertEquals(100, product.getMaximumStockLevel());
        assertEquals("disponível", product.getStatus());
    }

}
