package com.employee.portal.service;

import com.employee.portal.model.Documents;
import org.springframework.stereotype.Service;


public interface DocumentsService {
    public Documents getDocumentsById(int id);
    public String updateDocumentsById(int id, Documents documents);
    public Documents addDocumentsById(Documents documents);
}
