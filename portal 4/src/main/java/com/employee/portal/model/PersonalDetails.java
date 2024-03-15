package com.employee.portal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "personal_details")
public class PersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private int employeeId;
    @Column(name="name")
    private String name;
    @Column(name="dob")
    private Date dob;
    @Column(name="doj")
    private Date doj;
    @Column(name="role")
    private String role;
    @Column(name="level")
    private String level;
    @Column(name="email")
    private String email;
    @Column(name="phone_no")
    private String phoneNo;
    @Column(name="designation")
    private String designation;
    @Column(name="slack_url")
    private String slackUrl;
    @Column(name="pod")
    private String pod;
    @Column(name="address")
    private String address;
    @Column(name="image_url")
    private String imageUrl;
    @Column(name="badge_url")
    private String badgeUrl;
}