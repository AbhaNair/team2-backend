package com.employee.portal.controller;

import com.employee.portal.model.PersonalDetails;
import com.employee.portal.service.PersonalDetailsService;
import com.employee.portal.serviceImpl.PersonalDetailServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
public class PersonalDetailsController {

    @Autowired
    private PersonalDetailServiceImpl personalDetailsService;

    @GetMapping("/getPersonalDetails/{id}")
    public ResponseEntity<PersonalDetails> getPersonalDetailsById(@PathVariable int id){
        PersonalDetails personalDetails = personalDetailsService.getPersonalDetailsById(id);
        return new ResponseEntity<PersonalDetails>(personalDetails, HttpStatus.OK);
    }

    @PostMapping("/addPersonalDetails")
    public ResponseEntity<PersonalDetails> addPersoanlDetailsTree(@RequestBody PersonalDetails personalDetails) {
        PersonalDetails personalDetail = personalDetailsService.addPersoanlDetails(personalDetails);
        return new ResponseEntity<PersonalDetails>(personalDetail, HttpStatus.CREATED);
    }

    @PutMapping("/updatePersonalDetails/{id}")
    public ResponseEntity<String> updatePersonalDetailsById(@RequestBody PersonalDetails personalDetails, @PathVariable int id){
        String result  = personalDetailsService.updatePersonalDetailsById(id, personalDetails);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @GetMapping("/getPersonalDetailsContainingName/{name}")
    public ResponseEntity<List<PersonalDetails>> getPersonalDetailsContainingName(@PathVariable String name){
        List<PersonalDetails> personalDetails = personalDetailsService.getPersonalDetailsContainingName(name);
        return new ResponseEntity<List<PersonalDetails>>(personalDetails,HttpStatus.OK);
    }

    @GetMapping("/downloadPersonalDetailsCSV/{id}")
    public void downloadReporteesCSV(@PathVariable int id, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"PersonalDetails"+"("+id+")"+".csv\"");
        PersonalDetails user = personalDetailsService.getPersonalDetailsById(id);
        try (PrintWriter writer = response.getWriter()) {
            writer.println("EmployeeId,Name,Phone Number,Email,SlackUrl,Pod,Date of Joining,Date of Birth,Address");
            writer.println(
                    user.getEmployeeId() + "," +
                            user.getName() + "," +
                            user.getPhoneNo() + "," +
                            user.getEmail() + "," +
                            user.getSlackUrl() + "," +
                            user.getPod() + "," +
                            user.getDoj() + "," +
                            user.getDob() + "," +
                            user.getAddress()
            );
        }

    }
}
