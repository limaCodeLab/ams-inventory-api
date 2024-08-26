package com.skald.ats.inventory.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class ProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O nome do produto não pode ser nulo ou vazio ou deve ser informado")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String name;

    private String description;

    @NotBlank(message = "Fornecedor não pode ser nulo ou vazio")
    private String supplier;

    @NotBlank(message = "Categoria não pode ser nulo ou vazio")
    private String category;

    @Positive(message = "Valor unitário deve ser maior que zero")
    @NotNull(message = "Valor unitário não pode ser nulo ou deve ser informado no cadastro")
    private Double unitPrice;

    @Positive(message = "Quantidade em estoque deve ser maior que zero")
    @NotNull(message = "Quantidade em estoque não pode ser nulo ou deve ser informado no cadastro")
    private Integer quantityOnHand;

    @NotNull(message = "Nível mínimo de estoque não pode ser nulo ou deve ser informado no cadastro")
    private Integer minimalStockLevel;

    @NotNull(message = "Nível mínimo de estoque não pode ser nulo ou deve ser informado no cadastro")
    private Integer maximumStockLevel;

    private String status;

    private final LocalDateTime dateCreated;

    public ProductDTO() {
        dateCreated = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = (name != null) ? name.trim() : null;
    }

    public void setDescription(String description) {
        this.description = (description != null) ? description.trim() : null;
    }
}
