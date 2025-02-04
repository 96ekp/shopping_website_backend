package com.sawlov2code.shopping_website_backend.order.model;

import com.sawlov2code.shopping_website_backend.supplier.model.Supplier;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier_order", indexes = {
        @Index(name = "idx_supplier_id_order", columnList = "supplier_id"),
        @Index(name = "idx_order_date_supplier", columnList = "order_date")
})
public class SupplierOrder {
    @Id
    @SequenceGenerator(
            name = "supplier_order_sequence",
            sequenceName = "supplier_order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "supplier_order_sequence"
    )
    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "order_discount")
    private BigDecimal discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupplierOrderLine> orderLines = new ArrayList<>();

}
