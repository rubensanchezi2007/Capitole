package com.capitole.inditex.price.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonIgnore
    @ManyToOne
    @JoinColumn (name = "brand_id")
    Brand brand;

    @Column
    private LocalDateTime start_date;

    @Column
    private LocalDateTime end_date;

    @Column
    private Integer price_list;

    @Column
    private Long product_id;

    @Column
    private Integer priority;

    @Column
    private BigDecimal price;

    @Column
    private String currency;
}
