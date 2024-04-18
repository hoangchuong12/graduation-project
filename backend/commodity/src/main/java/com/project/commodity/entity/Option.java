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
@Table(name = "OPTION")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName  = "id")
    private Product ProductId;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName  = "id")
    private Category CategoryId;

    @Column(name="NAME")
    private String Name;

    @Column(name = "DESCIPTION")
    private String desciption;

    @Column(name = "DETAIL")
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
