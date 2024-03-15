package com.employee.portal.repository;

import com.employee.portal.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonalDetailsRepo extends JpaRepository<PersonalDetails, Integer> {

    @Query(value = "SELECT * FROM personal_details WHERE employee_id = :id", nativeQuery = true)
    PersonalDetails getPersonalDetailsById(@Param("id") int id);

    @Query(value = "SELECT * FROM personal_details WHERE name LIKE CONCAT('%', :name, '%')",nativeQuery = true)
    List<PersonalDetails> getPersonalDetailsContainingName(@Param("name") String name);

}
