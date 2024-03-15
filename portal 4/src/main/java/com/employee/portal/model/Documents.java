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
@Table(name = "document_details")
public class Documents {
    @Id
    @Column(name="employee_id")
    private int employeeId;
    @Column(name="aadhar_card")
    private String aadhaarCard;
    @Column(name="pan_card")
    private String panCard;
    @Column(name="offer_letter")
    private String offerLetter;

}
