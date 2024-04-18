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
@Table(name = "TAGS")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NAME")
    private String Name;
    
    @Column(name = "ICON")
    private String Icon;
    @Column(name = "CREATED_AT")
    private Timestamp CreatedAt;

    @Column(name = "UPDATED_AT")
    private Timestamp UpdatedAt;

    @Column(name = "CREATED_BY")
    private UUID CreatedBy;

    @Column(name = "UPDATED_BY")
    private UUID UpdatedBy;
    
}
