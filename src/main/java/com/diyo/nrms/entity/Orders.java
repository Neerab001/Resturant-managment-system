package com.diyo.nrms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private String orderDishName;
    private Double orderDishPrice;
    private Short orderQuantityOfDish;
    private Boolean orderReady;
    private Boolean orderDelivered;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="billId",referencedColumnName = "billId" )
    private Bill bill;


}
