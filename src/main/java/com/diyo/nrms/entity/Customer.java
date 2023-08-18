package com.diyo.nrms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private Boolean repeatedCustomer;




    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_Id",referencedColumnName = "orderId")
    private Orders orders;
/*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="order_Id",referencedColumnName = "orderId")
    private List<Orders> orders;*/


}
