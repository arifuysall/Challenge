package com.enoca.challenge.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private int id;
    private String name;
    private String surname;
    private int socialSecurityNumber;
    private String department;
    private int salary;
    private int companyId;
    private int workYear;
}
