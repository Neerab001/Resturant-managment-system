package com.diyo.nrms.controller;

import com.diyo.nrms.entity.Bill;
import com.diyo.nrms.exception.NotFoundException;
import com.diyo.nrms.service.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillController {
    private final BillService billService;

    public BillController(BillService billService){
        this.billService=billService;
    }

    @PostMapping("/createbill")
    public ResponseEntity<String> addBill(@RequestBody Bill bill){
        billService.addBill(bill);
        return ResponseEntity.ok("Bill has been added!");
    }
    @PostMapping("/createbilllist")
    public ResponseEntity<String> createBillList(@RequestBody List<Bill> bill){
        billService.createBillList(bill);
        return ResponseEntity.ok("Bill list has been added!");
    }
    @GetMapping("/dataout")
    public  ResponseEntity<List<Bill>> getAllBill(){
        return ResponseEntity.ok(billService.getAllBill());
    }
    @PatchMapping
    public ResponseEntity<String> updateBillPatchMethod(@RequestBody Bill bill){
        return ResponseEntity.ok(billService.updateBillPatchMethod(bill));
    }
    @DeleteMapping("/{billId}")
    public ResponseEntity<String> deleteBillById(@PathVariable("billId") Long billId){
        System.out.println("deleted by Rajee on the code");
        return ResponseEntity.ok(billService.deleteBillById(billId));
    }
    @GetMapping("/{billId}")
    public ResponseEntity<Bill> getBillById(@PathVariable("billId")Long billId)throws NotFoundException {
        return ResponseEntity.ok(billService.getBillById(billId));
    }

}
