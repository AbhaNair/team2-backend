package com.employee.portal.controller;


import com.employee.portal.model.Interest;
import com.employee.portal.service.InterestService;
import com.employee.portal.serviceImpl.InterestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterestController {

    @Autowired
    private InterestServiceImpl interestService;


    @GetMapping("/getInterest/{id}")
    public ResponseEntity<Interest> getInterestById(@PathVariable int id){
        Interest interest = interestService.getInterestById(id);
        return new ResponseEntity<Interest>(interest, HttpStatus.OK);
    }

    @PostMapping("/addInterest")
    public ResponseEntity<Interest> addInterestById(@RequestBody Interest interest) {
        Interest interests = interestService.addInterestById(interest);
        return new ResponseEntity<Interest>(interests, HttpStatus.CREATED);
    }

    @PutMapping("/updateInterest/{id}")
    public ResponseEntity<String> updateInterestById(@RequestBody Interest interest, @PathVariable int id){
        String result  = interestService.updateInterestById(interest, id);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @GetMapping("/getTagsContainingName/{tags}")
    public ResponseEntity<List<Interest>> getTagsContainingName(@PathVariable String tags){
        List<Interest> interest = interestService.getTagsContainingName(tags);
        return new ResponseEntity<List<Interest>>(interest, HttpStatus.OK);
    }

    @GetMapping("/getCommunityContainingName/{community}")
    public ResponseEntity<List<Interest>> getCommunityContainingName(@PathVariable String community){
        List<Interest> interest = interestService.getCommunityContainingName(community);
        return new ResponseEntity<List<Interest>>(interest, HttpStatus.OK);
    }


}
