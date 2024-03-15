package com.employee.portal.serviceImpl;

import com.employee.portal.model.Documents;
import com.employee.portal.repository.DocumentsRepo;
import com.employee.portal.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentsServiceImpl implements DocumentsService {

    @Autowired
    private DocumentsRepo documentsRepo;
    @Override
    public Documents getDocumentsById(int id) {
        return documentsRepo.getDocumentsById(id);
    }

    @Override
    public String updateDocumentsById(int id, Documents document) {
        Optional<Documents> documents = documentsRepo.findById(id);
        if(documents.isPresent()) {
            Documents doc = documents.get();
            doc.setAadhaarCard(document.getAadhaarCard());
            doc.setPanCard(document.getPanCard());
            doc.setOfferLetter(document.getOfferLetter());
            documentsRepo.save(doc);
            return "Updated Successfully";
        }
        return "Failed to Update";
    }

    @Override
    public Documents addDocumentsById(Documents documents) {
        return documentsRepo.save(documents);
    }
}
