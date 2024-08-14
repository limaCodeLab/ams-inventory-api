package com.skald.ats.inventory.api.unitTest.model.entities.messaging;

public interface ProductErrorMsg {

    String nameProductErrorMsg = "name: O nome do produto nao pode ser nulo";
    String supplierProductErrorMsg = "supplier: Fornecedor do produto nao pode ser nulo";
    String unitPriceProductErrorMsg = "unitPrice: Valor unitário do produto deve ser maior que zero e nao pode ser nulo";
    String categoryProductErrorMsg = "category: Categoria do produto nao pode ser nulo";
    String minimalStockProductErrorMsg = "minimalStockLevel: Nivel minimo de estoque deve ser maior que zero e nao pode ser nulo";
    String maximumStockProductErrorMsg = "maximumStockLevel: Nivel maximo de estoque deve ser maior que zero e nao pode ser nulo";
    String maxStockRuleProductErrorMsg = "maximumStockLevel: Nivel máximo de estoque não pode ser menor ou igual ao nível mínimo de estoque";

}