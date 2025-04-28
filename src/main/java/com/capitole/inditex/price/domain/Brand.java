package com.capitole.inditex.price.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String brand_name;
}
