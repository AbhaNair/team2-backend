package com.employee.portal.repository;

import com.employee.portal.model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocumentsRepo extends JpaRepository<Documents,Integer> {
    @Query(value = "SELECT * FROM document_details Where employee_Id = :id", nativeQuery = true)
    Documents getDocumentsById(@Param("id")int id);
}
