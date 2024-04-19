package com.thaihoangchuong.bannerservice.entity;


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
@Table(name = "BANNERS")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NAME")
    private String Name;

    @Column(name = "IMAGE")
    private String Image;

    @Column(name = "DESCRIPTION")
    private String Description;

    
    @Column(name = "CREATED_AT")
    private Timestamp CreatedAt;

    @Column(name = "UPDATED_AT")
    private Timestamp UpdatedAt;

    @Column(name = "CREATED_BY")
    private UUID CreatedBy;

    @Column(name = "UPDATED_BY")
    private UUID UpdatedBy;
}
