package com.employee.portal.repository;

import com.employee.portal.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterestRepo extends JpaRepository<Interest,Integer> {
    @Query(value = "SELECT * FROM interest Where employee_id = :id", nativeQuery = true)
    Interest getInterestById(@Param("id") int id);

    @Query(value = "SELECT * FROM interest WHERE tags LIKE CONCAT('% ', :tags, ' %')",nativeQuery = true)
    List<Interest> getTagsContainingName(@Param("tags") String tags);

    @Query(value = "SELECT * FROM interest WHERE community LIKE CONCAT('%', :community, '%')",nativeQuery = true)
    List<Interest> getCommunitiesContainingName(@Param("community") String community);
}
