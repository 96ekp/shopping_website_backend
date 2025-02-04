package com.sawlov2code.shopping_website_backend.user.model;

import com.sawlov2code.shopping_website_backend.address.model.Address;
import com.sawlov2code.shopping_website_backend.order.model.CustomerOrder;
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
@Table(name = "user_account", indexes = {
        @Index(name = "idx_user_account_email_address", columnList = "email_address")
})
public class UserAccount {

    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String first_name;
    
    @Column(name ="last_name")
    private String last_name;

    @Column(name = "email_address")
    private String email_address;

    // Many-to-many relationship with address
    @ManyToMany
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    private List<CustomerOrder> orders = new ArrayList<>();

}
