package com.enoca.challenge.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Employee extends BaseEntity{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private Integer age;

    @Column(unique = true,length = 6,nullable = false)
    private String socialSecurityNumber;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private Integer salary;

    @Column(nullable = false)
    private Integer workYear;

    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "company_id", nullable = false,updatable = false,insertable = false)
    private Company company;

    @Column(name = "company_id",nullable = false)
    private Integer companyId;


}
