package com.sawlov2code.shopping_website_backend.product.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "colour", indexes = @Index(name = "idx_colour_colour_name", columnList = "colour_name"))
public class Colour {
    @Id
    @SequenceGenerator(
            name = "colour_sequence",
            sequenceName = "colour_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "colour_sequence"
    )
    @Column(name = "colour_id")
    private Long colour_id;

    @Column(name = "colour_name")
    private String name;

    @OneToMany(mappedBy = "colour")
    private List<Product> products = new ArrayList<>();
}
