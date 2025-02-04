package com.sawlov2code.shopping_website_backend.product.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @SequenceGenerator(
            name = "product_category_sequence",
            sequenceName = "product_category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_category_sequence"
    )
    @Column(name ="category_id")
    private Long category_id;

    @Column(name = "category_name")
    private String category_name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();


}
