package com.thaihoangchuong.bannerservice.entity;

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
@Table(name = "INFORMATION")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NAME")
    private String Name;

    @Column(name = "LOGO")
    private String Logo;

    @Column(name = "ADDRESS")
    private String Address;

    @Column(name = "EMAIL")
    private String Email;

    @Column(name ="PHONE")
    private int Phone;

    @Column(name = "BUSINNESS_NUMBER")
    private int BusinessNumber;

    @Column(name ="LICENSE")
    private String License;

    @Column(name = "REPRESENT")
    private String Represent;

    @Column(name ="REPRESENT_Phone")
    private String RepresentPhone;
}
