package com.employee.portal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "login_details")
public class LoginDetails {
    @Id
    @Column(name="employee_id")
    private int employeeId;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

}
