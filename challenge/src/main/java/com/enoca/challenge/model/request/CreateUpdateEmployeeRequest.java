package com.enoca.challenge.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateEmployeeRequest {
    private String name;
    private String surname;
    private int age;
    private int socialSecurityNumber;
    private String department;
    private int salary;
    private int companyId;
    private int workYear;
}
