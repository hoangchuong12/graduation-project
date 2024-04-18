package com.project.commodity.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id")
    private Category CategoryId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id")
    private Product ProductId;

}
