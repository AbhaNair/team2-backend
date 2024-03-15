package com.employee.portal.service;

import com.employee.portal.model.PersonalDetails;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonalDetailsService {
    public PersonalDetails getPersonalDetailsById(int id);
    public String updatePersonalDetailsById(int id, PersonalDetails personalDetails);
    public PersonalDetails addPersoanlDetails(PersonalDetails personalDetails);

    public List<PersonalDetails> getPersonalDetailsContainingName(String name);

}
