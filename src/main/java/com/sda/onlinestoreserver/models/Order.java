package com.sda.onlinestoreserver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false, referencedColumnName = "id")
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "order_status_id", nullable = false, referencedColumnName = "id")
    private OrderStatus orderStatus;


}
