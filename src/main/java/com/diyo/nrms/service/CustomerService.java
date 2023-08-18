package com.diyo.nrms.service;

import com.diyo.nrms.entity.Customer;
import com.diyo.nrms.exception.NotFoundException;
import com.diyo.nrms.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer){
    customerRepository.save(customer);
    }
    public void addCustomerList(List<Customer>customers) {
        customerRepository.saveAll(customers);
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCusotmerById(Long customerId)throws NotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        } else {

            throw new NotFoundException("No record found!"+customerId);
                    }
    }

    public String updateCustomerPutMethod(Customer customer){
        Optional<Customer> customerOptional=customerRepository.findById(customer.getCustomerId());
        if(customerOptional.isPresent()){
            customerRepository.save(customer);
            return("Customer data has been updated!");
        }
        else{
            return("No Customer data found!");
        }
    }

    public String updateCustomerPatchMethod(Customer customer){
        Optional<Customer> customerOptional=customerRepository.findById(customer.getCustomerId());
        if(customerOptional.isPresent()){
            Customer existingCustomerData=customerOptional.get();
            if(customer.getCustomerName()!=null){
                existingCustomerData.setCustomerName(customer.getCustomerName());
            }
            if(customer.getCustomerEmail()!=null){
                existingCustomerData.setCustomerEmail(customer.getCustomerEmail());
            }
            if(customer.getCustomerPhone()!=null){
                existingCustomerData.setCustomerPhone(customer.getCustomerPhone());
            }
            if(customer.getRepeatedCustomer()!=null){
                existingCustomerData.setRepeatedCustomer(customer.getRepeatedCustomer());
            }
            customerRepository.save(existingCustomerData);
            return "Customer data patched!";
        }
        else{
            return "The customer you are trying to update does not exist in our record!";
        }
    }
    public String deleteCustomerById(Long customerId){
        customerRepository.deleteById(customerId);
        return"Customer record deleted";
    }
    public List<Customer> findCustomerByCustomerName(String customerName){
        return customerRepository.findCustomerByCustomerName(customerName);
    }
}