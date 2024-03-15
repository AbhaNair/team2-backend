package com.employee.portal.serviceImpl;

import com.employee.portal.model.EmployeeDetails;
import com.employee.portal.repository.EmployeeDetailsRepo;
import com.employee.portal.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

    @Autowired
    private EmployeeDetailsRepo employeeDetailsRepo;

    @Override
    public EmployeeDetails getEmployeeDetails(int id) {
        return employeeDetailsRepo.getEmployeeDetails(id);
    }



    @Override
    public String updateEmployeeDetails(int id, EmployeeDetails employeeDetails) {
        Optional<EmployeeDetails> employeeDetailsInstance= employeeDetailsRepo.findById(id);
        List<Optional<EmployeeDetails>> reporteesLength = employeeDetailsRepo.getAllReporteesById(id);
        int numberOfReportees = reporteesLength.size();
        if(employeeDetailsInstance.isPresent()){
            EmployeeDetails employee =employeeDetailsInstance.get();
            employee.setDesignation(employeeDetails.getDesignation());
            employee.setName(employeeDetails.getName());
            employee.setLevel(employeeDetails.getLevel());
            employee.setManagerId(employeeDetails.getManagerId());
            employee.setNumberOfReportees(numberOfReportees);
            employeeDetailsRepo.save(employee);
            return "Updated Successfully";
        }
        return "Login Credentials is invalid";
    }

    @Override
    public EmployeeDetails addEmployeeDetails(EmployeeDetails employeeDetails) {
        int managerId = employeeDetails.getManagerId();
        List<Optional<EmployeeDetails>> reporteesLength = employeeDetailsRepo.getAllReporteesById(employeeDetails.getEmployeeId());
        int numberOfReportees = reporteesLength.size();
        employeeDetails.setNumberOfReportees(numberOfReportees);
        List<Optional<EmployeeDetails>> managersReporteesLength = employeeDetailsRepo.getAllReporteesById(employeeDetails.getEmployeeId());
        int numberOfManagersReportees = managersReporteesLength.size()+1;
        Optional<EmployeeDetails> managersData = employeeDetailsRepo.findById(managerId);
        EmployeeDetails manager = managersData.get();
        manager.setNumberOfReportees(numberOfManagersReportees);
        EmployeeDetails managerData = employeeDetailsRepo.save(manager);
        return employeeDetailsRepo.save(employeeDetails);
    }

    @Override
    public List<Optional<EmployeeDetails>> getAllReporteesById(int id){
        List<Optional<EmployeeDetails>> employeeDetailsInstance = employeeDetailsRepo.getAllReporteesById(id);
        return employeeDetailsInstance;
    }


}
