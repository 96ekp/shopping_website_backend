package com.sawlov2code.shopping_website_backend.product.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "size", indexes = @Index(name = "idx_size_size_name", columnList = "size_name"))
public class Size {
    @Id
    @SequenceGenerator(
            name = "size_sequence",
            sequenceName = "size_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "size_sequence"
    )
    @Column(name = "size_id")
    private Long size_id;

    @Column(name = "size_name")
    private String name;

    @OneToMany(mappedBy = "size")
    private List<Product> products = new ArrayList<>();
}
