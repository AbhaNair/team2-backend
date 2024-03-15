package com.employee.portal.service;

import com.employee.portal.model.BankDetails;
import org.springframework.stereotype.Service;


public interface BankDetailsService {
    public BankDetails getBankDetailsById(int id);
    public String updateBankDetailsById(int id, BankDetails bankDetails);
    public BankDetails addBankDetails(BankDetails bankDetails);
}
