package com.skald.ats.inventory.api.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String name;

    private String description;

    @Column(nullable = false)
    private String supplier;

    @Column(nullable = false)
    private String category;

    private String status;

    @Column(name = "valor_unitario", nullable = false, precision = 2)
    private Double unitPrice;

    @Column(name = "quantity_on_hand", nullable = false)
    private Integer quantityOnHand;

    @Column(name = "minimal_stock_level", nullable = false)
    private Integer minimalStockLevel;

    @Column(name = "maximum_stock_level", nullable = false)
    private Integer maximumStockLevel;

    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private LocalDateTime dateCreated;

    public Product(){}

    @PrePersist
    @PreUpdate
    private void trimFields(){
        this.name = (name != null) ? name.trim() : null;
        this.description = (description != null) ? description.trim() : null;
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
                + ", status=" + status + ", quantityOnHand=" + quantityOnHand + "]";
    }

}
