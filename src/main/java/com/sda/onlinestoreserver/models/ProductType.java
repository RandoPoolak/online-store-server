package com.sda.onlinestoreserver.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categories;

    private boolean isActive;
}
