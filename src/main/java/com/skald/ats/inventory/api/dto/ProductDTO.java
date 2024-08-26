package com.skald.ats.inventory.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skald.ats.inventory.api.exception.ValidationDataException;
import com.skald.ats.inventory.api.utils.StringUtils;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
public class ProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(required = true)
    @NotBlank(message = "O nome do produto não pode ser nulo ou vazio")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String name;

    private String description;

    @JsonProperty(required = true)
    @NotBlank(message = "Fornecedor não pode ser nulo ou vazio")
    private String supplier;

    @JsonProperty(required = true)
    @NotBlank(message = "Categoria não pode ser nulo ou vazio")
    private String category;

    @JsonProperty(required = true)
    @Positive(message = "Valor unitário deve ser maior que zero")
    @NotNull(message = "Valor unitário não pode ser nulo")
    private Double unitPrice;

    @JsonProperty(required = true)
    @Positive(message = "Quantidade em estoque deve ser maior que zero")
    @NotNull(message = "Quantidade em estoque não pode ser nulo")
    private Integer quantityOnHand;

    @Min(value = 1, message = "Nível mínimo de estoque deve ser maior que zero")
    @NotNull(message = "Nível mínimo de estoque deve ser informado")
    private Integer minimalStockLevel;

    @Positive(message = "Nível máximo de estoque deve ser maior que zero")
    @NotNull(message = "Nível mínimo de estoque não pode ser nulo")
    private Integer maximumStockLevel;

    private String status;

    private final LocalDateTime dateCreated;

    public ProductDTO() {
        dateCreated = LocalDateTime.now();
        quantityOnHand = 0;
    }

    public ProductDTO(String name, String description, String supplier,
                   String category, Double unitPrice, Integer minimalStockLevel,
                   Integer maximumStockLevel, Integer quantityOnHand, String status) {
        this();
        this.name = name;
        this.description = description;
        this.supplier = supplier;
        this.category = category;
        this.unitPrice = unitPrice;
        this.quantityOnHand = quantityOnHand;
        this.minimalStockLevel = minimalStockLevel;
        this.maximumStockLevel = maximumStockLevel;
        this.status = status;
    }
}
