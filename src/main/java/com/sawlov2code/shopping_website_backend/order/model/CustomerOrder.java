package com.sawlov2code.shopping_website_backend.order.model;


import com.sawlov2code.shopping_website_backend.address.model.Address;
import com.sawlov2code.shopping_website_backend.user.model.UserAccount;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_order", indexes = {
        @Index(name = "idx_username", columnList = "username"),
        @Index(name = "idx_order_date", columnList = "order_date")
})
public class CustomerOrder {
    @Id
    @SequenceGenerator(
            name = "customer_order_sequence",
            sequenceName = "customer_order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_order_sequence"
    )
    @Column(name = "order_id")
    private Long order_id;


    @Column(name = "order_discount")
    private BigDecimal discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_address")
    private Address shippingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_address")
    private Address billingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private UserAccount user;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerOrderLine> orderLines = new ArrayList<>();
}
