package com.project.commodity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.UUID;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", referencedColumnName  = "id")
    private Brand BrandId;

    @Column(name = "PRODUCT_NAME")
    private String ProductName;

    @Column(name = "PRICE")
    private double Price;

    @Column(name = "DETAIL")
    private double detail;

    @Column (name ="DESCRIPTION")
    private String Description;

    @Column (name ="EVALUATE")
    private Integer evaluate;

    @Column(name = "CREATED_AT")
    private Timestamp CreatedAt;

    @Column(name = "UPDATED_AT")
    private Timestamp UpdatedAt;

    @Column(name = "CREATED_BY")
    private UUID CreatedBy;

    @Column(name = "UPDATED_BY")
    private UUID UpdatedBy;

    @Column(name = "STATUS")
    private Integer satatus;

}
