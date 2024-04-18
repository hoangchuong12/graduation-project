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
@Table(name = "BRANDS")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "BRAND_NAME")
    private String BrandName;
    @Column(name = "IMAGE")
    private String Image;
    @Column(name ="DESCIPTION")
    private String desciption;
    @Column(name = "TITLE")
    private String Title;
    @Column (name = "ADDRESS")
    private String Address;
    @Column(name = "CREATED_AT")
    private Timestamp CreatedAt;
    @Column(name = "UPDATED_AT")
    private Timestamp UpdatedAt;
    @Column (name = "CREATED_BY")
    private UUID CreatedBy;
    @Column (name = "UPDATED_BY")
    private UUID UpdatedBy;
    @Column(name = "STATUS")
    private Integer status;
}