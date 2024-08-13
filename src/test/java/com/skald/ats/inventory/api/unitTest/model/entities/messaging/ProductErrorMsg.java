package com.skald.ats.inventory.api.unitTest.model.entities.messaging;

public class ProductErrorMsg {

    public final String nameProduct = "name: O nome do produto nao pode ser nulo";
    public final String supplierProduct = "supplier: Fornecedor do produto nao pode ser nulo";
    public final String unitPriceProduct = "unitPrice: Valor unitário do produto deve ser maior que zero e nao pode ser nulo";
    public final String categoryProduct = "category: Categoria do produto nao pode ser nulo";
    public final String minimalStockLevelProduct = "minimalStockLevel: Nivel minimo de estoque deve ser maior que zero e nao pode ser nulo";
    public final String maximumStockLevelProduct = "maximumStockLevel: Nivel maximo de estoque deve ser maior que zero e nao pode ser nulo";
    public final String maxStockRuleProduct = "maximumStockLevel: Nivel máximo de estoque não pode ser menor ou igual ao nível mínimo de estoque";

}