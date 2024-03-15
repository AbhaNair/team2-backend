package com.employee.portal.service;

import com.employee.portal.model.Interest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InterestService {
    public Interest getInterestById(int id);
    public Interest addInterestById(Interest interest);
    public String updateInterestById(Interest interest, int id);

    public List<Interest> getTagsContainingName(String tags);
    public List<Interest> getCommunityContainingName(String community);
}
