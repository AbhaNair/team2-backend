package com.employee.portal.controller;

import com.employee.portal.model.LoginDetails;
import com.employee.portal.service.LoginService;
import com.employee.portal.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoginDetailsController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginDetails> login(@RequestBody LoginDetails loginRequest){
        LoginDetails user = loginService.login(loginRequest.getEmail(),loginRequest.getPassword());
        if(user.getEmail() == null)return new ResponseEntity<LoginDetails>(user,HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/addLoginDetails")
    public ResponseEntity<LoginDetails> addLoginDetailsById(@RequestBody LoginDetails loginDetails) {
        LoginDetails loginDetail = loginService.addLoginDetails(loginDetails);
        return new ResponseEntity<LoginDetails>(loginDetail, HttpStatus.CREATED);
    }

    @PutMapping("/updateLoginDetails/{id}")
    public ResponseEntity<String> updateLoginDetails(@RequestBody LoginDetails loginDetails, @PathVariable int id){
        String result  = loginService.updateLoginDetails(id, loginDetails);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Integer> authenticate(@RequestBody LoginDetails loginDetails) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        Optional<LoginDetails> dbLoginDetails = loginService.getLoginDetailsByEmail(loginDetails.getEmail());
        if(dbLoginDetails.isPresent()) {
            LoginDetails userLogin = dbLoginDetails.get();
            if(bCrypt.matches( loginDetails.getPassword(), userLogin.getPassword())) {
                return new ResponseEntity<Integer>(userLogin.getEmployeeId(),HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
