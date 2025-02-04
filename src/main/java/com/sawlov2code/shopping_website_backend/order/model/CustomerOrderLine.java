package com.sawlov2code.shopping_website_backend.order.model;

import com.sawlov2code.shopping_website_backend.product.model.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "customer_order_line", indexes = {
        @Index(name = "idx_product_id", columnList = "product_id"),
        @Index(name = "idx_order_id", columnList = "order_id")
})
public class CustomerOrderLine {
    @Id
    @SequenceGenerator(
            name = "customer_order_line_sequence",
            sequenceName = "customer_order_line_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_order_line_sequence"
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
    private CustomerOrder order;

}
