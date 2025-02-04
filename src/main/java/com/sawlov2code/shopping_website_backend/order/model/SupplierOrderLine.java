package com.sawlov2code.shopping_website_backend.order.model;

import com.sawlov2code.shopping_website_backend.product.model.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "supplier_order_line", indexes = {
        @Index(name = "idx_supplier_product_id", columnList = "product_id"),
        @Index(name = "idx_supplier_order_id", columnList = "order_id")
})
public class SupplierOrderLine {
    @Id
    @SequenceGenerator(
            name = "supplier_order_line_sequence",
            sequenceName = "supplier_order_line_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "supplier_order_line_sequence"
    )
    @Column(name = "order_line_id")
    private Long order_line_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
    private BigDecimal discount;
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private SupplierOrder order;

}
