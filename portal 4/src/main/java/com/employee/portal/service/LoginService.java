package com.employee.portal.service;

import com.employee.portal.model.LoginDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface LoginService {
    public LoginDetails getLoginDetailsById(int id);
    public LoginDetails addLoginDetails(LoginDetails loginDetails);
    public String updateLoginDetails(int id, LoginDetails loginDetails);

    public LoginDetails login(String email, String password);

    public Optional<LoginDetails> getLoginDetailsByEmail(String email);
}
