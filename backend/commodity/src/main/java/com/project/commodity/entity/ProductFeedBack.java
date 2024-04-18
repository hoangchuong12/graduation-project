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
@Table(name = "PRODUCT_FEEDBACKS")
public class ProductFeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "ORDER_ITEM_ID")
    private UUID OrderItemId;

    @Column(name  = "USER_ID")
    private UUID UserID;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id")
    private Product ProductId;

    @Column (name  =  "EVALUATE")
    private int Evaluate;

    @Column (name = "IMAGE")
    private String Image;

    @Column (name =  " DESCRIPTION")
    private String description;

    @Column (name = "DETAIL")
    private String Detail;

    @Column(name = "CREATED_AT")
    private Timestamp CreatedAt;

    @Column(name = "UPDATED_AT")
    private Timestamp UpdatedAt;

    @Column(name = "CREATED_BY")
    private UUID CreatedBy;

    @Column(name = "UPDATED_BY")
    private UUID UpdatedBy;


}
