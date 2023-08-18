package com.diyo.nrms.controller;


import com.diyo.nrms.entity.Customer;
import com.diyo.nrms.exception.NotFoundException;
import com.diyo.nrms.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){

        this.customerService=customerService;
    }

    @PostMapping("/addcustomer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
       return ResponseEntity.ok("Individual customer entry sucessful!");
    }

    @PostMapping("/addcustomerlist")
    public ResponseEntity<String> addCustomerList(@RequestBody List<Customer> customer){
        customerService.addCustomerList(customer);
        return ResponseEntity.ok("Customer list added!");
    }

    @GetMapping("/dataout")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PutMapping//put by Id
    public  ResponseEntity<String>updateCustomerPutMethod(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomerPutMethod(customer));
    }

    @PatchMapping
    public ResponseEntity<String> updateCustomerPatchMethod(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomerPatchMethod(customer));
    }

    @DeleteMapping("/{cId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("cId") Long customerId){
        return ResponseEntity.ok(customerService.deleteCustomerById(customerId));
    }

    @GetMapping("/{cId}")
    public ResponseEntity<Customer> getCusotmerById(@PathVariable("cId")Long customerId)throws NotFoundException {
        return ResponseEntity.ok(customerService.getCusotmerById(customerId));
    }


    @GetMapping("/searchCustomerByName/{customerName}")
    public List<Customer> findCustomerByCustomerName(@PathVariable("customerName")String customerName){
        return customerService.findCustomerByCustomerName(customerName);
    }


}
