package com.sawlov2code.shopping_website_backend.supplier.model;

import com.sawlov2code.shopping_website_backend.order.model.SupplierOrder;
import com.sawlov2code.shopping_website_backend.product.model.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier", indexes = @Index(name = "idx_supplier_supplier_name", columnList = "supplier_name"))
public class Supplier {
    @Id
    @SequenceGenerator(
            name = "supplier_sequence",
            sequenceName = "supplier_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "supplier_sequence"
    )
    @Column(name = "supplier_id")
    private Long supplier_id;

    @Column(name = "supplier_name")
    private String name;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "supplier")
    private List<SupplierOrder> orders = new ArrayList<>();

}
