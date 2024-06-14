package com.fleming99.CustomerAPI.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "customer_first_name")
    private String customerFirstName;

    @Column(name = "customer_last_name")
    private String customerLastName;

    @Column(name = "customer_birth_date")
    private LocalDate customerBirthDate;

    @Column(name = "customer_reg_date")
    private LocalDateTime customerRegDate;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_secret")
    @JsonIgnore
    private String customerPassword;

    @Column(name = "active_profile")
    private boolean activeProfile;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<CustomerAddress> addresses;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "customer_role_relationship",
                joinColumns = @JoinColumn(name = "customer_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<CustomerRoles> customerRole;
}
