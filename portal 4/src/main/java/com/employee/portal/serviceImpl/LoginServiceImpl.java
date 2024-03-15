package com.employee.portal.serviceImpl;

import com.employee.portal.model.LoginDetails;
import com.employee.portal.repository.LoginServiceRepo;
import com.employee.portal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginServiceRepo loginServiceRepo;


    @Override
    public LoginDetails getLoginDetailsById(int id) {
        return loginServiceRepo.getLoginDetailsById(id);
    }

        @Override
        public LoginDetails addLoginDetails(LoginDetails loginDetails){
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            String encryptedPwd = bcrypt.encode(loginDetails.getPassword());
            loginDetails.setPassword(encryptedPwd);
            return loginServiceRepo.save(loginDetails);
        }

    @Override
        public String updateLoginDetails(int id,LoginDetails loginDetails ) {
        Optional<LoginDetails> loginDetailsInstance= loginServiceRepo.findById(id);
        if(loginDetailsInstance.isPresent()){
            LoginDetails login =loginDetailsInstance.get();
            login.setEmail(loginDetails.getEmail());
            login.setPassword(loginDetails.getPassword());
            loginServiceRepo.save(login);
            return "Updated Successfully";
        }
        return "Login Credentials is invalid";
    }

    @Override
    public LoginDetails login(String email, String password) {
        Optional<LoginDetails> loginDetails = loginServiceRepo.findByEmail(email);
        if (loginDetails.isPresent()) {
            LoginDetails user = loginDetails.get();
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return new LoginDetails();
    }
    @Override
    public Optional<LoginDetails> getLoginDetailsByEmail(String email) {
        return loginServiceRepo.findByEmail(email);
    }
}
