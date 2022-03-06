package com.sda.onlinestoreserver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="product_types")
@Getter
@Setter
@NoArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 45)
    private String name;

    @OneToMany(mappedBy = "productType")
    private List<Category> categories = new ArrayList<>();

}
