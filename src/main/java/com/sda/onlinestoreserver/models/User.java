package com.sda.onlinestoreserver.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String password;

    private String logoUrl;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private ContactMethod contactMethod;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    private boolean isActive;

}
