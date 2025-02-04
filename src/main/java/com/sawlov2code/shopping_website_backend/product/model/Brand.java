package com.sawlov2code.shopping_website_backend.product.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand", indexes = {
        @Index(name = "idx_brand_brand_name", columnList = "brand_name")
})
public class Brand {
    @Id
    @SequenceGenerator(
            name = "brand_sequence",
            sequenceName = "brand_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "brand_sequence"
    )
    @Column(name = "brand_id")
    private Long brand_id;


    @Column(name = "brand_name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();

}
