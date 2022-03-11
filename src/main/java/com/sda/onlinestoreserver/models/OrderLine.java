package com.sda.onlinestoreserver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="order_lines")
@Getter
@Setter
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false, referencedColumnName = "id")
    private Order order;

}
