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
@Table(name = "bank_details")
public class BankDetails {
    @Id
    @Column(name="employee_id")
    private int employeeId;
    @Column(name="account_number")
    private String accountNumber;
    @Column(name="account_type")
    private String accountType;
    @Column(name="holder_name")
    private String holderName;
    @Column(name="bank_name")
    private String bankName;
    @Column(name="branch_name")
    private String branchName;
    @Column(name="ifsc_code")
    private String ifscCode;
}
