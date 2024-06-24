package com.skald.ats.inventory.api.entities;

import jakarta.persistence.*;
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
    @Setter
    private String name;
    @Setter
    private String description;
    @Setter
    private String supplier;
    @Setter
    private String category;
    @Setter
    private double costPrice;
    @Setter
    private double salePrice;
    @Setter
    private int quantity;
    @Setter
    @Column(name = "minimal_stock_level")
    private int minimalStockLevel;
    @Setter
    @Column(name = "maximum_stock_level")
    private int maximumStockLevel;
    private Instant dateCreated;
    @Setter
    private Instant expiryDate;
    @Setter
    private String status;
    @Setter
    private String barCode;


    public Product() {
    }

    public Product(Long id, String name, String description,
                   String supplier, String category, double costPrice,
                   double salePrice, int quantity, int minimalStockLevel,
                   int maximumStockLevel, Instant dateCreated, Instant expiryDate,
                   String status, String barCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.supplier = supplier;
        this.category = category;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.minimalStockLevel = minimalStockLevel;
        this.maximumStockLevel = maximumStockLevel;
        this.dateCreated = dateCreated;
        this.expiryDate = expiryDate;
        this.status = status;
        this.barCode = barCode;
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
                + ", category=" + category + ", costPrice=" + costPrice + ", salePrice=" + salePrice
                + ", quantity=" + quantity + ", minimalStockLevel=" + minimalStockLevel
                + ", maximumStockLevel=" + maximumStockLevel + ", dateCreated=" + dateCreated
                + ", expiryDate=" + expiryDate + ", status=" + status + ", barCode=" + barCode + "]";
    }

}
