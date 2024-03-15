package com.employee.portal.controller;

import com.employee.portal.model.EmployeeDetails;
import com.employee.portal.serviceImpl.EmployeeDetailsServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeDetailsController {

    @Autowired
    private EmployeeDetailsServiceImpl employeeDetailsService;


    @GetMapping("/getEmployeeDetails/{id}")
    public ResponseEntity<EmployeeDetails> getEmployeeDetails(@PathVariable int id){
        EmployeeDetails employeeDetails = employeeDetailsService.getEmployeeDetails(id);
        return new ResponseEntity<EmployeeDetails>(employeeDetails, HttpStatus.OK);
    }
    @GetMapping("/getAllReporteesById/{id}")
    public ResponseEntity<List<Optional<EmployeeDetails>>> getReporteesDetails(@PathVariable int id){
        List<Optional<EmployeeDetails>> employeeReporteesDetails = employeeDetailsService.getAllReporteesById(id);
        return new ResponseEntity<List<Optional<EmployeeDetails>>>(employeeReporteesDetails, HttpStatus.OK);
    }

    @PostMapping("/addEmployeeDetails")
    public ResponseEntity<EmployeeDetails> addEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
        EmployeeDetails addEmployeeDetails = employeeDetailsService.addEmployeeDetails(employeeDetails);
        return new ResponseEntity<EmployeeDetails>(addEmployeeDetails, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployeeDetails/{id}")
    public ResponseEntity<String> updateEmployeeDetails(@RequestBody EmployeeDetails employeeDetails, @PathVariable int id){
        String result  = employeeDetailsService.updateEmployeeDetails(id, employeeDetails);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @GetMapping("/downloadReporteesCSV/{id}")
    public void downloadReporteesCSV(@PathVariable int id, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"reportees for "+"("+id+")"+".csv\"");
        List<Optional<EmployeeDetails>> reportees = employeeDetailsService.getAllReporteesById(id);
        try (PrintWriter writer = response.getWriter()) {
            writer.println("EmployeeId,Name,Designation");
            for (Optional<EmployeeDetails> reportee : reportees) {
                if (reportee.isPresent()) {
                    EmployeeDetails details = reportee.get();
                    writer.println(
                            details.getEmployeeId() + "," +
                                    details.getName() + "," +
                                    details.getDesignation()
                    );
                }
            }
        }
    }
}
