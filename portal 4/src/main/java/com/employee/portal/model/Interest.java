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
@Table(name = "interest")
public class Interest {
    @Id
    @Column(name="employee_id")
    private int employeeId;
    @Column(name="community")
    private String community;
    @Column(name="tags")
    private String tags;
}
