package com.diyo.nrms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Country {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long countryId;

    String name;
    String countryCode;
    Date fromDate;
    Date toDate;


}
