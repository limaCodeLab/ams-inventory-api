package com.skald.ats.inventory.api.model.entities;

import com.skald.ats.inventory.api.service.exceptions.ValidationDataException;
import com.skald.ats.inventory.api.util.StringUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;


@Getter
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome deve ser informado")
    @Column(nullable = false, length = 100)
    private String name;
    private String description;

    @NotNull(message = "Fornecedor deve ser informado")
    @Column(nullable = false)
    private String supplier;

    @NotNull(message = "Categoria deve ser informada")
    @Column(nullable = false)
    private String category;

    @Setter
    private String status;

    @Positive
    @NotNull(message = "Valor unitário deve ser informado")
    @Column(name = "valor_unitario", nullable = false, precision = 2)
    private Double unitPrice;

    @Min(value = 1, message = "Nível mínimo de estoque deve ser maior que zero")
    @NotNull(message = "Nível mínimo de estoque deve ser informado")
    @Column(name = "minimal_stock_level", nullable = false)
    private Integer minimalStockLevel;

    @NotNull(message = "Nível mínimo de estoque deve ser informado")
    @Column(name = "maximum_stock_level", nullable = false)
    private Integer maximumStockLevel;

    @Column(updatable = false)
    private LocalDateTime dateCreated;


    public Product() {
    }

    public Product(Long id, String name, String description, String supplier,
                   String category, Double unitPrice, Integer minimalStockLevel,
                   Integer maximumStockLevel, String status) {
        this.id = id;
        setName(name);
        setDescription(description);
        setSupplier(supplier);
        setCategory(category);
        setUnitPrice(unitPrice);
        setMinimalStockLevel(minimalStockLevel);
        setMaximumStockLevel(maximumStockLevel);
        setDateCreated();
        this.status = status;
    }

    public Product(String name, String description, String supplier,
                   String category, Double unitPrice, Integer minimalStockLevel,
                   Integer maximumStockLevel, String status) {
        setName(name);
        setDescription(description);
        setSupplier(supplier);
        setCategory(category);
        setUnitPrice(unitPrice);
        setMinimalStockLevel(minimalStockLevel);
        setMaximumStockLevel(maximumStockLevel);
        setDateCreated();
        this.status = status;
    }

    public void setName(String name) {
        Optional.ofNullable(name)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .orElseThrow(() -> new ValidationDataException("name","O nome do produto nao pode ser nulo"));
        this.name = name.trim();
    }

    public void setDescription(String description) {
        this.description = StringUtils.normalizeString(description);
    }

    public void setSupplier(String supplier) {
        Optional.ofNullable(supplier)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .orElseThrow(() -> new ValidationDataException("supplier","Fornecedor do produto nao pode ser nulo"));
        this.supplier = supplier;

    }

    public void setCategory(String category) {
        Optional.ofNullable(category)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .orElseThrow(() -> new ValidationDataException("category","Categoria do produto nao pode ser nulo"));
        this.category = category;

    }

    public void setUnitPrice(Double unitPrice) {
        Optional.ofNullable(unitPrice)
                .filter(price -> price > 0)
                .orElseThrow(() -> new ValidationDataException("unitPrice",
                        "Valor unitário do produto deve ser maior que zero e nao pode ser nulo"));
        this.unitPrice = unitPrice;
    }

    public void setMinimalStockLevel(Integer minimalStockLevel) {
        Optional.ofNullable(minimalStockLevel)
                .filter(level -> level > 0)
                .orElseThrow(() -> new ValidationDataException("minimalStockLevel",
                        "Nivel minimo de estoque deve ser maior que zero e nao pode ser nulo"));
        this.minimalStockLevel = minimalStockLevel;
    }

    public void setMaximumStockLevel(Integer maximumStockLevel) {
        Optional.ofNullable(maximumStockLevel)
                .filter(level -> level > 0)
                .orElseThrow(() -> new ValidationDataException("maximumStockLevel",
                        "Nivel maximo de estoque deve ser maior que zero e nao pode ser nulo"));
        if (maximumStockLevel <= this.minimalStockLevel){
            throw new ValidationDataException("maximumStockLevel",
                    "Nivel máximo de estoque não pode ser menor ou igual ao nível mínimo de estoque");
        }
        this.maximumStockLevel = maximumStockLevel;
    }

    @PrePersist
    public void setDateCreated() {
        this.dateCreated = LocalDateTime.now();
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
