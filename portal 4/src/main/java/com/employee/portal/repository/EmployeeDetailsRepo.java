package com.employee.portal.repository;

import com.employee.portal.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails,Integer> {

    @Query(value = "SELECT * FROM employee_details WHERE employee_id = :id", nativeQuery = true)
    EmployeeDetails getEmployeeDetails(@Param("id") int id);

    @Query(value = "SELECT * FROM employee_details WHERE manager_id = :id", nativeQuery = true)
    List<Optional<EmployeeDetails>> getAllReporteesById(@Param("id") int id);
}
