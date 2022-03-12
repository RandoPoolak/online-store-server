package com.sda.onlinestoreserver.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    private boolean isActive;

}
