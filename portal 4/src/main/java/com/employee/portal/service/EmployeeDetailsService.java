package com.employee.portal.service;

import com.employee.portal.model.EmployeeDetails;

import java.util.List;
import java.util.Optional;

public interface EmployeeDetailsService {
    public EmployeeDetails getEmployeeDetails(int id);

    public List<Optional<EmployeeDetails>> getAllReporteesById(int id);
    public String updateEmployeeDetails(int id, EmployeeDetails employeeDetail);
    public EmployeeDetails addEmployeeDetails(EmployeeDetails employeeDetail);

}

