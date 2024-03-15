package com.employee.portal.controller;

import com.employee.portal.model.BankDetails;
import com.employee.portal.model.Documents;
import com.employee.portal.serviceImpl.DocumentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DocumentsController {
    @Autowired
    DocumentsServiceImpl documentsService;

    @GetMapping("/getDocumentDetails/{id}")
    public ResponseEntity<Documents> getDocumentDetailsById(@PathVariable int id){
        Documents documents = documentsService.getDocumentsById(id);
        return new ResponseEntity<Documents>(documents, HttpStatus.OK);
    }

    @PostMapping("/addDocumentsDetails")
    public ResponseEntity<Documents> addDocumentDetails(@RequestBody Documents documents) {
        Documents document =documentsService.addDocumentsById(documents);
        return new ResponseEntity<Documents>(document, HttpStatus.CREATED);
    }

    @PutMapping("/updateDocumentDetails/{id}")
    public ResponseEntity<String> updateBankDetailsById(@RequestBody Documents documents, @PathVariable int id){
        String result  = documentsService.updateDocumentsById(id, documents);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
