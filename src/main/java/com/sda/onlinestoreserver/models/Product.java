package com.sda.onlinestoreserver.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private String thumbnailUrl;

    private BigDecimal price;

    private Integer stock;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private Author author;

    private boolean isActive;
}
