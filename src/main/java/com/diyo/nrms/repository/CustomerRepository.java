package com.diyo.nrms.repository;

import com.diyo.nrms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    List<Customer>findCustomerByCustomerName(String a);

}
