package com.sda.onlinestoreserver.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime orderDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private User user;
}
