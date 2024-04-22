package com.thaihoangchuong.bannerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SLIDER")
public class Slider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "NAME")
    private String Name;

    @Column (name="IMAGE")
    private String Image;

    @Column(name = "CREATED_AT")
    private LocalDateTime CreatedAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime UpdatedAt;

    @Column(name = "CREATED_BY")
    private UUID CreatedBy;

    @Column(name = "UPDATED_BY")
    private UUID UpdatedBy;
}
