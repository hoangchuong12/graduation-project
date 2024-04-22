package com.thaihoangchuong.bannerservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;

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
    @Lob
    private byte[] image;

    @Column(name = "DESCRIPTION")
    private String Description;

    
    @Column(name = "CREATED_AT")
    private LocalDateTime CreatedAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime UpdatedAt;

    @Column(name = "CREATED_BY")
    private UUID CreatedBy;

    @Column(name = "UPDATED_BY")
    private UUID UpdatedBy;
}
