package com.employee.portal.controller;

import com.employee.portal.model.BankDetails;
import com.employee.portal.model.PersonalDetails;
import com.employee.portal.service.PersonalDetailsService;
import com.employee.portal.serviceImpl.BankDetailsServiceImpl;
import com.employee.portal.serviceImpl.PersonalDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankDetailsController {

    @Autowired
    private BankDetailsServiceImpl bankDetailsService;

    @GetMapping("/getBankDetails/{id}")
    public ResponseEntity<BankDetails> getBankDetailsById(@PathVariable int id){
        BankDetails bankDetails = bankDetailsService.getBankDetailsById(id);
        return new ResponseEntity<BankDetails>(bankDetails, HttpStatus.OK);
    }

    @PostMapping("/addBankDetails")
    public ResponseEntity<BankDetails> addBankDetails(@RequestBody BankDetails bankDetails) {
        BankDetails bank = bankDetailsService.addBankDetails(bankDetails);
        return new ResponseEntity<BankDetails>(bank, HttpStatus.CREATED);
    }

    @PutMapping("/updateBankDetails/{id}")
    public ResponseEntity<String> updateBankDetailsById(@RequestBody BankDetails bankDetails, @PathVariable int id){
        String result  = bankDetailsService.updateBankDetailsById(id, bankDetails);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
