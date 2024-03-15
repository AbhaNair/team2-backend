package com.employee.portal.serviceImpl;

import com.employee.portal.model.Interest;
import com.employee.portal.repository.InterestRepo;
import com.employee.portal.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestRepo interestRepo;

    @Override
    public Interest getInterestById(int id) {
        return interestRepo.getInterestById(id);
    }

    @Override
    public Interest addInterestById(Interest interest) {
        Interest interestInstance = interestRepo.save(interest);
        return interestInstance;
    }

    @Override
    public String updateInterestById(Interest interest, int id) {
        Optional<Interest> interestInstance = interestRepo.findById(id);
            Interest interst = interestInstance.get();
            interst.setCommunity(interst.getCommunity());
            interst.setTags(interest.getTags());
            interestRepo.save(interst);
            return "Updated Successfully";
    }

    @Override
    public List<Interest> getTagsContainingName(String tags) {
        return interestRepo.getTagsContainingName(tags);
    }

    @Override
    public List<Interest> getCommunityContainingName(String community) {
        return interestRepo.getCommunitiesContainingName(community);
    }
}
