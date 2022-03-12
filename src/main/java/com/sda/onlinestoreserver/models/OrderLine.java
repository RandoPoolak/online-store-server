package com.sda.onlinestoreserver.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    private Integer quantity;

    private boolean isActive;

}
