package com.diyo.nrms.service;

import com.diyo.nrms.entity.Bill;
import com.diyo.nrms.exception.NotFoundException;
import com.diyo.nrms.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    private final BillRepository billRepository;

    public BillService(BillRepository billRepository){
        this.billRepository=billRepository;
    }
    public void addBill(Bill bill){
        billRepository.save(bill);
    }
    public void createBillList(List<Bill> bill) {
        billRepository.saveAll(bill);
    }
    public List<Bill> getAllBill(){
        return billRepository.findAll();
    }
    public Bill getBillById(Long billId)throws NotFoundException {
        Optional<Bill> billOptional = billRepository.findById(billId);
        if (billOptional.isPresent()) {
            return billOptional.get();
        } else {
            throw new NotFoundException("No record found!"+billId);
        }
    }

    public String updateBillPatchMethod( Bill bill){
        Optional<Bill> billOptional=billRepository.findById(bill.getBillId());
        if(billOptional.isPresent()){
            Bill existingBillData=billOptional.get();
            if(bill.getBillStatus()!=null){
                existingBillData.setBillStatus(bill.getBillStatus());
            }
            billRepository.save(existingBillData);
            return "Bill data patched!";
        }
        else{
            return "The bill you are trying to update does not exist in our record!";
        }
    }
    public String deleteBillById(Long billNo){
        billRepository.deleteById(billNo);
        return"Bill record deleted";
    }
}
