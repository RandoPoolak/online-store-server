package com.sda.onlinestoreserver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 128)
    private String description;

    @Column(name="thumbnail_url",nullable = false,length = 256)
    private String thumbnailUrl;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderLine> orderLineList = new ArrayList<>();

}
