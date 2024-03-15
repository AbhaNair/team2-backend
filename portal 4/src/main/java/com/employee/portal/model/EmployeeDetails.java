package com.employee.portal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    @Id
    @Column(name="employee_id")
    private int employeeId;
    @Column(name="name")
    private String name;
    @Column(name="designation")
    private String designation;
    @Column(name="level")
    private String level;
    @Column(name="manager_id")
    private int managerId;
    @Column(name="number_of_reportees")
    private int NumberOfReportees;
    @Column(name="image_url")
    private String imageUrl;
}
