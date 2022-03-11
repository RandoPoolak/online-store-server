package com.sda.onlinestoreserver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 45)
    private String login;

    @Column(nullable = false, length = 128)
    private String password;

    @Column(name = "logo_url", nullable = false, length = 256)
    private String logoUrl;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "contact_method_id", nullable = false, referencedColumnName = "id")
    private ContactMethod contactMethod;

}
