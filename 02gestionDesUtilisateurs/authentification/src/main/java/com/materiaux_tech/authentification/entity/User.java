package com.materiaux_tech.authentification.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Set<Role> roles;

}
