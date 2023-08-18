package com.diyo.nrms.repository;

import com.diyo.nrms.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
    List<Orders> findOrdersByOrOrderDishName(String a);

}
