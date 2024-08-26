package com.skald.ats.inventory.api.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
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

    @Column(updatable = false)
    private LocalDateTime dateCreated;

    @PrePersist
    @PreUpdate
    private void trimFields(){
        this.name = (name != null) ? name.trim() : null;
        this.description = (description != null) ? description.trim() : null;
    }
}
