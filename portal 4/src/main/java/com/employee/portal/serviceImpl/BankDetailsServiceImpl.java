package com.employee.portal.serviceImpl;

import com.employee.portal.model.BankDetails;
import com.employee.portal.repository.BankDetailsRepo;
import com.employee.portal.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankDetailsServiceImpl implements BankDetailsService {

    @Autowired
    private  BankDetailsRepo bankDetailsRepo;


    @Override
    public BankDetails getBankDetailsById(int id) {
        return bankDetailsRepo.getBankDetailsById(id);
    }

    @Override
    public String updateBankDetailsById(int id, BankDetails bankDetails) {
        Optional<BankDetails> bankDetailInstance= bankDetailsRepo.findById(id);
        if(bankDetailInstance.isPresent()){
            BankDetails bank =bankDetailInstance.get();
            bank.setBankName(bankDetails.getBankName());
            bank.setAccountType(bankDetails.getAccountType());
            bank.setAccountNumber(bankDetails.getAccountNumber());
            bank.setBankName(bankDetails.getBankName());
            bank.setBranchName(bankDetails.getBranchName());
            bank.setHolderName(bankDetails.getHolderName());
            bank.setIfscCode(bankDetails.getIfscCode());
            bankDetailsRepo.save(bank);
            return "Updated Successfully";
        }
        return "Employee not found";
    }

    @Override
    public BankDetails addBankDetails(BankDetails bankDetails) {
        BankDetails bankDetailInstance = bankDetailsRepo.save(bankDetails);
        return bankDetailInstance;
    }

}

