package com.employee.portal.repository;

import com.employee.portal.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankDetailsRepo extends JpaRepository<BankDetails,Integer> {

    @Query(value = "SELECT * FROM bank_details Where employee_Id = :id", nativeQuery = true)
    BankDetails getBankDetailsById(@Param("id")int id);
}
