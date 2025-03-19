package com.materialstech.productservice.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    private String name;

    @Column(length = 2000)
    private String description;


    private double price;

    @Column(length = 8)
    private String currency;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Category> categories= new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Image> images= new ArrayList<>();


}
