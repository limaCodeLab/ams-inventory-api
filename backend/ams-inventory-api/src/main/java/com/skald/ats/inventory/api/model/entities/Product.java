package com.skald.ats.inventory.api.model.entities;

import com.skald.ats.inventory.api.service.exceptions.NotificationException;
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
    private String supplier;
    @Setter
    @NotNull(message = "A categoria deve ser informada")
    @Column(nullable = false)
    private String category;
    @Setter
    private String status;

    @Positive(message = "O preço de custo deve ser maior que zero.")
    @Column(name = "valor_unitario", nullable = false, precision = 2)
    private Double unitPrice;

    @Min(value = 1, message = "O nível mínimo de estoque deve ser maior que zero")
    @Column(name = "minimal_stock_level", nullable = false)
    private Integer minimalStockLevel;

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
        if (unitPrice <= 0.00){
            throw new NotificationException("O valor unitário deve ser maior que zero");
        }
        this.unitPrice = unitPrice;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NotificationException("O nome do item deve ser informado");
        }
        this.name = name;
    }


    public void setMinimalStockLevel(int minimalStockLevel) {
        if (minimalStockLevel <= 0){
            throw new NotificationException("O nível mínimo de estoque deve ser maior que zero");
        }
        this.minimalStockLevel = minimalStockLevel;
    }

    public void setMaximumStockLevel(int maximumStockLevel) {
        if (maximumStockLevel <= this.minimalStockLevel){
            throw new NotificationException("O nível máximo de estoque não pode ser menor ou igual ao nível mínimo de estoque");
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
