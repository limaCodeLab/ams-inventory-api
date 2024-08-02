package com.skald.ats.inventory.api.model.entities;

import com.skald.ats.inventory.api.service.exceptions.ValidationDataException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;


@Getter
@Entity
@Table(name = "tb_items")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome deve ser informado")
    @Column(nullable = false, length = 100)
    private String name;

    @Setter
    private String description;

    @Setter
    @NotNull(message = "O fornecedor deve ser informado")
    @Column(nullable = false)
    private String supplier;

    @Setter
    @NotNull(message = "A categoria deve ser informada")
    @Column(nullable = false)
    private String category;

    @Setter
    private String status;

    @Positive
    @NotNull(message = "O valor unitário deve ser informado")
    @Column(name = "valor_unitario", nullable = false, precision = 2)
    private Double unitPrice;

    @Min(value = 1, message = "O nível mínimo de estoque deve ser maior que zero")
    @NotNull(message = "O nível mínimo de estoque deve ser informado")
    @Column(name = "minimal_stock_level", nullable = false)
    private Integer minimalStockLevel;

    @NotNull(message = "O nível mínimo de estoque deve ser informado")
    @Column(name = "maximum_stock_level", nullable = false)
    private Integer maximumStockLevel;
    private Instant dateCreated;


    public Product() {
    }

    public Product(Long id, String name, String description, String supplier,
                   String category, Double unitPrice, Integer minimalStockLevel,
                   Integer maximumStockLevel, Instant dateCreated, String status) {
        this.id = id;
        setName(name);
        this.description = description;
        this.supplier = supplier;
        this.category = category;
        setUnitPrice(unitPrice);
        setMinimalStockLevel(minimalStockLevel);
        setMaximumStockLevel(maximumStockLevel);
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public void setUnitPrice(Double unitPrice) {
        Optional.ofNullable(unitPrice)
                .filter(price -> price > 0)
                .orElseThrow(() -> new ValidationDataException("unitPrice","O valor unitário deve ser maior que zero"));
        this.unitPrice = unitPrice;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationDataException("name","O nome do item deve ser informado");
        }
        this.name = name;
    }


    public void setMinimalStockLevel(Integer minimalStockLevel) {
        Optional.ofNullable(minimalStockLevel)
                .orElseThrow(() -> new ValidationDataException("minimalStockLevel","Valor mínimo de estoque não pode ser nulo"));
        if (minimalStockLevel <= 0){
            throw new ValidationDataException("minimalStockLevel","Valor mínimo de estoque deve ser maior que zero");
        }
        this.minimalStockLevel = minimalStockLevel;
    }

    public void setMaximumStockLevel(Integer maximumStockLevel) {
        Optional.ofNullable(maximumStockLevel)
                .orElseThrow(() -> new ValidationDataException("maximumStockLevel","Valor máximo de estoque não pode ser nulo"));
        if (maximumStockLevel <= this.minimalStockLevel){
            throw new ValidationDataException("maximumStockLevel","Valor máximo de estoque não pode ser menor ou igual ao nível mínimo de estoque");
        }
        this.maximumStockLevel = maximumStockLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", supplier=" + supplier
                + ", category=" + category + ", costPrice=" + unitPrice + ", minimalStockLevel=" + minimalStockLevel
                + ", maximumStockLevel=" + maximumStockLevel + ", dateCreated=" + dateCreated
                + ", status=" + status + "]";
    }

}
