package com.sawlov2code.shopping_website_backend.product.model;

import com.sawlov2code.shopping_website_backend.order.model.CustomerOrderLine;
import com.sawlov2code.shopping_website_backend.supplier.model.Supplier;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product", indexes = {
        @Index(name = "idx_product_product_name", columnList = "product_name"),
        @Index(name = "idx_product_product_category_id", columnList = "product_category_id"),
        @Index(name = "idx_brand_id", columnList = "brand_id"),
        @Index(name = "idx_colour_id", columnList = "colour_id"),
        @Index(name = "idx_size_id", columnList = "size_id"),
        @Index(name = "idx_supplier_id", columnList = "supplier_id")
})
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "proudct_name")
    private String product_name;

    // many-to-one relationship with category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    private ProductCategory category;

    // many-to-one relationship with brand
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    // many-to-one relationship with color
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colour_id")
    private Colour colour;

    // many-to-one relationship with size
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    private Size size;

    // many-to-one relationship with supplier
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;



    @OneToMany(mappedBy = "product")
    private List<CustomerOrderLine> orderLines = new ArrayList<>();

}
