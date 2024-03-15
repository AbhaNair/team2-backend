package com.employee.portal.serviceImpl;

import com.employee.portal.model.PersonalDetails;
import com.employee.portal.repository.PersonalDetailsRepo;
import com.employee.portal.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalDetailServiceImpl implements PersonalDetailsService {

    @Autowired
    private PersonalDetailsRepo personalDetailsRepo;

    @Override
    public PersonalDetails getPersonalDetailsById(int id) {
        return personalDetailsRepo.getPersonalDetailsById(id);
    }

    @Override
    public String updatePersonalDetailsById(int id, PersonalDetails personalDetails) {
        Optional<PersonalDetails> personalDetailsInstance= personalDetailsRepo.findById(id);
        if(personalDetailsInstance.isPresent()){
            PersonalDetails perDetails =personalDetailsInstance.get();
            perDetails.setAddress(personalDetails.getAddress());
            perDetails.setDesignation(personalDetails.getDesignation());
            perDetails.setEmail(personalDetails.getEmail());
            perDetails.setName(personalDetails.getName());
            perDetails.setDob(personalDetails.getDob());
            perDetails.setDoj(personalDetails.getDoj());
            perDetails.setLevel(personalDetails.getLevel());
            perDetails.setRole(personalDetails.getRole());
            perDetails.setPod(personalDetails.getPod());
            perDetails.setPhoneNo(personalDetails.getPhoneNo());
            perDetails.setSlackUrl(personalDetails.getSlackUrl());
            personalDetailsRepo.save(perDetails);
            return "Updated Successfully";
        }
        return "Employee not found.";
    }

    @Override
    public PersonalDetails addPersoanlDetails(PersonalDetails personalDetails) {
        return personalDetailsRepo.save(personalDetails);
    }

    @Override
    public List<PersonalDetails> getPersonalDetailsContainingName(String name) {
        return personalDetailsRepo.getPersonalDetailsContainingName(name);
    }
}
