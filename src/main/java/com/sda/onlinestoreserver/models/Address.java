package com.sda.onlinestoreserver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String street;

    @Column(name = "zip_code", nullable = false, length = 50)
    private String zipCode;

    @Column(name ="is_default", nullable = false)
    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false, referencedColumnName = "id")
    private User user;

}
