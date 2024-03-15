package com.employee.portal.repository;

import com.employee.portal.model.Interest;
import com.employee.portal.model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginServiceRepo extends JpaRepository<LoginDetails,Integer> {
    @Query(value = "SELECT * FROM login_details WHERE employee_id = :id", nativeQuery = true)
    LoginDetails getLoginDetailsById(@Param("id") int id);

    Optional<LoginDetails> findByEmail(String email);

}
