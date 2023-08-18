package com.diyo.nrms.repository;

import com.diyo.nrms.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {
    List<Bill> findBillByBillId(Long a);
}
