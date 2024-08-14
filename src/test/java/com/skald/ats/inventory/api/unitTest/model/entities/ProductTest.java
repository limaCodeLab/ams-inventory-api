package com.skald.ats.inventory.api.unitTest.model.entities;

import com.skald.ats.inventory.api.service.exceptions.ValidationDataException;
import com.skald.ats.inventory.api.model.entities.Product;
import com.skald.ats.inventory.api.unitTest.model.entities.messaging.ProductErrorMsg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest implements ProductErrorMsg{

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Filtro de Óleo","Filtro de óleo pARa    MOtor   ",
                "Fornecedor A", "Filtros", 26.50,
                5, 100, "disponível");
    }

    @Test
    @DisplayName("Sucesso na criação de um novo produto com parametros validos")
    void testEntityProduct_QuandoCriadoComParametrosValidos_EntaoNaoDeveRetornarErro() {
        assertEquals("Filtro de Óleo", product.getName());
        assertEquals("Filtro de óleo para motor", product.getDescription());
        assertEquals("Fornecedor A", product.getSupplier());
        assertEquals("Filtros", product.getCategory());
        assertEquals(26.50, product.getUnitPrice());
        assertEquals(5, product.getMinimalStockLevel());
        assertEquals(100, product.getMaximumStockLevel());
        assertEquals("disponível", product.getStatus());
    }

    @Test
    @DisplayName("Erro ao criar produto com nome nulo")
    void testEntityProduct_QuandoCriadoComNameNulo_EntaoDeveRetornarErro() {
        String[] invalidParam = {null, " ", ""};

        for (String param : invalidParam) {
            ValidationDataException exception = assertThrows(ValidationDataException.class, () -> {
                product.setName(param);
            });
            assertEquals(nameProductErrorMsg, exception.getMessage());
        }
    }

    @Test
    @DisplayName("Erro ao criar produto com fornecedor nulo")
    void testEntityProduct_QuandoCriadoComSupplierNuol_EntaoDeveRetornarErro() {
        String[] invalidParam = {null, " ", ""};

        for (String param : invalidParam) {
            ValidationDataException exception = assertThrows(ValidationDataException.class, () -> {
                product.setSupplier(param);
            });
            assertEquals(supplierProductErrorMsg, exception.getMessage());
        }
    }

    @Test
    @DisplayName("Erro ao criar produto com categoria nula")
    void testEntityProduct_QuandoCriadoComCategoryNulo_EntaoDeveRetornarErro() {
        String[] invalidParam = {null, " ", ""};

        for (String param : invalidParam) {
            ValidationDataException exception = assertThrows(ValidationDataException.class, () -> {
                product.setCategory(param);
            });
            assertEquals(categoryProductErrorMsg, exception.getMessage());
        }
    }

    @Test
    @DisplayName("Erro ao criar produto com preco unitario nulo, zero ou menor que zero")
    void testEntityProduct_QuandoCriadoComUnitPriceNuloOuZeroOuNegativo_EntaoDeveRetornarErro() {

        Double[] invalidParam = {null, 0.00, -1.00};
        for(Double param : invalidParam){
            ValidationDataException exception = assertThrows(ValidationDataException.class, () -> {
                product.setUnitPrice(param);
            });

            assertEquals(unitPriceProductErrorMsg, exception.getMessage());
        }
    }

    @Test
    @DisplayName("Erro ao criar produto com nivel minimo estoque nulo, zero ou menor que zero")
    void testEntityProduct_QuandoCriadoComMinimalStockLevelNuloOuZeroOuNegativo_EntaoDeveRetornarErro() {

        Integer[] invalidParam = {null, 0, -1};
        for(Integer param : invalidParam){
            ValidationDataException exception = assertThrows(ValidationDataException.class, () -> {
                product.setMinimalStockLevel(param);
            });

            assertEquals(minimalStockProductErrorMsg, exception.getMessage());
        }
    }

    @Test
    @DisplayName("Erro ao criar produto com nivel maximo estoque nulo, zero ou menor que zero")
    void testEntityProduct_QuandoCriadoComMaximumStockLevelNuloOuZeroOuNegativo_EntaoDeveRetornarErro() {

        Integer[] invalidParam = {null, 0, -1};
        for(Integer param : invalidParam){
            ValidationDataException exception = assertThrows(ValidationDataException.class, () -> {
                product.setMaximumStockLevel(param);
            });

            assertEquals(maximumStockProductErrorMsg, exception.getMessage());
        }
    }

    @Test
    @DisplayName("Erro ao criar produto com nivel maximo menor ou igual ao nivel minimo")
    void testEntityProduct_QuandoCriadoComMaximumStockLevelMenorQueMinimalStockLevel_EntaoDeveRetornarErro() {
        product.setMinimalStockLevel(2);
        Integer[] invalidParam = {1, 2};
        for(Integer param : invalidParam){
            ValidationDataException exception = assertThrows(ValidationDataException.class, () -> {
                product.setMaximumStockLevel(param);
            });

            assertEquals(maxStockRuleProductErrorMsg, exception.getMessage());
        }
    }

}