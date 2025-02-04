package com.sawlov2code.shopping_website_backend.address.model;

import com.sawlov2code.shopping_website_backend.order.model.CustomerOrder;
import com.sawlov2code.shopping_website_backend.user.model.UserAccount;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"

    )
    @Column(name = "address_id")
    private Long address_id;

    @Column(name = "house_unit_no")
    private String house_unit_no;

    @Column(name = "address_line1")
    private String address_line1;

    @Column(name = "address_line2")
    private String address_line2;

    @Column(name="city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name= "country")
    private String country;

    @ManyToMany(mappedBy = "addresses")
    private List<UserAccount> users = new ArrayList<>();

    @OneToMany(mappedBy = "shippingAddress")
    private List<CustomerOrder> shippingOrders = new ArrayList<>();
//
//    @OneToMany(mappedBy = "billingAddress")
//    private List<CustomerOrder> billingOrders = new ArrayList<>();



}
