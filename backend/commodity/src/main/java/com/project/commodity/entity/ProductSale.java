package com.project.commodity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PRODUCT_SALES")
public class ProductSale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName  = "id")
    private Product ProductId;

    @Column(name = "QUANTITY")
    private Double Quantity;

    @Column( name = "PRICE_SALE")
    private double PriceSale;

    @Column (name = "DETAIL")
    private String Detail;

    @Column (name = "DESCIPTION")
    private String Desciption;

    @Column(name = "DATE_BEGIN")
    private Timestamp DateBegin;

    @Column(name = "DATE_END")
    private Timestamp DateEnd;

    @Column(name = "CREATED_AT")
    private Timestamp CratedAt;

    @Column(name = "UPDATED_AT")
    private Timestamp UpdatedAt;
}
