package com.sda.onlinestoreserver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact_methods")
@Getter
@Setter
@NoArgsConstructor
public class ContactMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 45)
    private String name;

    @OneToMany(mappedBy = "contactMethod")
    private List<User> users = new ArrayList<>();

}
