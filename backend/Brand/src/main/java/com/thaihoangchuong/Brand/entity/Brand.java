package com.thaihoangchuong.Brand.entity;

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
@Table(name = "Brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "Brand_NAME")
    private String BrandName;
    @Column(name = "CREATED_AT")
    private Timestamp CreatedAt;
    @Column(name = "UPDATED_AT")
    private Timestamp UpdatedAt;
    @Column (name = "CREATED_BY")
    private UUID CreatedBy;
    @Column (name = "UPDATED_BY")
    private UUID UpdatedBy;
}
